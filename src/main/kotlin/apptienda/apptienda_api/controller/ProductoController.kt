package apptienda.apptienda_api.controller

import apptienda.apptienda_api.model.Producto
import apptienda.apptienda_api.repository.ProductoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/producto")
class ProductoController (
    private val productoRepository: ProductoRepository
) {

    @GetMapping
    fun getProducto(): List<Producto> {
        return productoRepository.findAll()
    }

    @GetMapping("/buscar")
    fun buscarPorNombre(@RequestParam nombre: String): List<Producto> {
        return productoRepository.findByNombreContainingIgnoreCase(nombre)
    }

    @GetMapping("/categoria")
    fun filtrarPorCategoria(@RequestParam categoria: String): List<Producto> {
        return productoRepository.findByCategoria(categoria)
    }
}