package apptienda.apptienda_api.model

import apptienda.apptienda_api.DTO.CarritoAdd
import apptienda.apptienda_api.repository.CarritoRepository
import apptienda.apptienda_api.repository.ProductoRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.Long


@Service
class CarritoService (
    private val carritoRepository: CarritoRepository,
    private val productoRepository: ProductoRepository
) {

    @Transactional
    fun agregarItem(item: CarritoAdd) {

        val itemExistente = carritoRepository.findByUsuarioId(item.usuarioId)
            .find { it.productoCodigo == item.productoCodigo }

        if (itemExistente != null) {
            val itemActualizado = itemExistente.copy(
                cantidad = itemExistente.cantidad + item.cantidad
            )
            carritoRepository.save(itemActualizado)

        } else {
            val nuevoItem = CarritoItem(
                usuarioId = item.usuarioId,
                productoCodigo = item.productoCodigo,
                cantidad = item.cantidad
            )
            carritoRepository.save(nuevoItem)
        }
    }

    fun obtenerCarritoPorUsuario(usuarioId: Long): List<CarritoAdd> {

        val items = carritoRepository.findByUsuarioId(usuarioId)

        return items.map { item ->

            val producto = productoRepository.findByCodigo(item.productoCodigo)
                ?: throw RuntimeException("Producto no encontrado: ${item.productoCodigo}")

            CarritoAdd(
                productoCodigo = item.productoCodigo,
                usuarioId = item.usuarioId,
                nombreProducto = producto.nombre,
                precioUnitario = producto.precio,
                cantidad = item.cantidad
            )
        }
    }

    fun vaciarCarritoPorUsuario(usuarioId: Long) {
        carritoRepository.deleteByUsuarioId(usuarioId)
    }
}