package apptienda.apptienda_api.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "producto")
data class Producto (
    @Id
    val codigo: String? = null,
    val categoria: String,
    @Column(name = "nombre")
    val nombre: String? = null,
    val precio: Int,
    val descripcion: String,
    val rating: Float? = null
)