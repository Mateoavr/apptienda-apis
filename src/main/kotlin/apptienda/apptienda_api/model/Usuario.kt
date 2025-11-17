package apptienda.apptienda_api.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "usuario")
data class Usuario (


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nombre: String,
    @Column(unique = true)
    val correo: String,
    val contrasena: String,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val fechaNacimiento: String,
    @Column(name = "es_duoc")
    val esDuoc: Boolean = false
    )