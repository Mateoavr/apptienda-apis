package apptienda.apptienda_api.repository

import apptienda.apptienda_api.model.Producto
import org.springframework.data.jpa.repository.JpaRepository

interface ProductoRepository  : JpaRepository<Producto, String> {

    fun findByCodigo(codigo: String): Producto?

    fun findByNombreContainingIgnoreCase(nombre: String): List<Producto>


    fun findByCategoria(categoria: String): List<Producto>
}