package apptienda.apptienda_api.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "carrito")
 data class CarritoItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val usuarioId: Long,
    @Column(name = "producto_codigo")
    val productoCodigo: String,
    val cantidad: Int
)