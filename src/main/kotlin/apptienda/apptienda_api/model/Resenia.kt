package apptienda.apptienda_api.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "resenias")
data class Resenia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "codigo_producto")
    val codigo: String,
    val usuario: String,
    val comentario: String,
    val calificacion: Int,
    val fecha: LocalDateTime = LocalDateTime.now()
)