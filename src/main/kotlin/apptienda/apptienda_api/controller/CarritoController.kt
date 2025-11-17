package apptienda.apptienda_api.controller

import apptienda.apptienda_api.DTO.CarritoAdd

import apptienda.apptienda_api.model.CarritoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CarritoController(
    private val carritoService: CarritoService
) {

    @PostMapping("/carrito/agregar")
    fun agregarAlCarrito(@RequestBody item: CarritoAdd): ResponseEntity<Unit> {
        carritoService.agregarItem(item)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/carrito/{usuarioId}")
    fun obtenerCarrito(@PathVariable usuarioId: Long): ResponseEntity<List<CarritoAdd>> {
        val carro = carritoService.obtenerCarritoPorUsuario(usuarioId)
        return ResponseEntity.ok(carro)
    }

    @PostMapping("/carrito/vaciar/{usuarioId}")
    fun vaciarCarrito(@PathVariable usuarioId: Long): ResponseEntity<Unit> {
        carritoService.vaciarCarritoPorUsuario(usuarioId)
        return ResponseEntity.ok().build()
    }
}
