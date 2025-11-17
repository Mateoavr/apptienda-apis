package apptienda.apptienda_api.repository

import apptienda.apptienda_api.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {


    fun findByCorreo(correo: String): Usuario?
}