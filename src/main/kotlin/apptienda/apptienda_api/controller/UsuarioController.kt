package apptienda.apptienda_api.controller

import apptienda.apptienda_api.model.Usuario
import apptienda.apptienda_api.model.sevice.UsuarioService

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

data class LoginRequest(val correo: String, val contrasena: String)
class RegistroRequest(
    val nombre: String,
    val correo: String,
    val contrasena: String,
    val fechaNacimiento: String
)

@RestController
@RequestMapping("/api")
class UsuarioController(

    private val usuarioService: UsuarioService
) {
    private val logger = Logger.getLogger(UsuarioController::class.java.name)


    @PostMapping("/registrar")
    fun registrar(@RequestBody request: Usuario): ResponseEntity<Usuario> {
        logger.info("Intento de registro para correo: ${request.correo}")


        val nuevoUsuario = Usuario(
            nombre = request.nombre,
            correo = request.correo,
            contrasena = request.contrasena,
            fechaNacimiento = request.fechaNacimiento
        )

        val usuarioRegistrado = usuarioService.registrar(nuevoUsuario)

        return if (usuarioRegistrado != null) {

            ResponseEntity(usuarioRegistrado.copy(contrasena = ""), HttpStatus.CREATED)
        } else {

            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }


    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Usuario> {
        logger.info("Intento de login para correo: ${request.correo}")

        val usuarioLogueado = usuarioService.login(request.correo, request.contrasena)

        return if (usuarioLogueado != null) {

            ResponseEntity(usuarioLogueado, HttpStatus.OK)
        } else {

            ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }
    @GetMapping("/usuarios")
    fun obtenerUsuarios(): ResponseEntity<List<Usuario>> {
        logger.info("Solicitud para obtener todos los usuarios")


        val listaUsuarios = usuarioService.obtenerTodos()


        val usuariosSinContrasena = listaUsuarios.map { usuario ->
            usuario.copy(contrasena = "")
        }


        return ResponseEntity(usuariosSinContrasena, HttpStatus.OK)
    }
}