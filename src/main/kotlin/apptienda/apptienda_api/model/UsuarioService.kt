package apptienda.apptienda_api.model

import apptienda.apptienda_api.repository.UsuarioRepository
import org.springframework.stereotype.Service
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

private val passwordEncoder = BCryptPasswordEncoder()
@Service
class UsuarioService (

    private val usuarioRepository: UsuarioRepository
) {
    fun registrar(nuevoUsuario: Usuario): Usuario? {

        val hashedPassword = passwordEncoder.encode(nuevoUsuario.contrasena)
        val usuarioParaGuardar = nuevoUsuario.copy(contrasena = hashedPassword)

        return try {
            usuarioRepository.save(usuarioParaGuardar)
        } catch (e: Exception) {

            println("Error al registrar: ${e.message}")
            null
        }
    }


    fun login(correo: String, contrasena: String): Usuario? {
        val usuario = usuarioRepository.findByCorreo(correo)

        return if (usuario != null && passwordEncoder.matches(contrasena, usuario.contrasena)) {

            usuario.copy(contrasena = "")
        } else {
            null
        }
    }
    fun obtenerTodos(): List<Usuario> {

        return usuarioRepository.findAll()
    }
}