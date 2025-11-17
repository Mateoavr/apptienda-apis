package apptienda.apptienda_api.repository

import apptienda.apptienda_api.model.CarritoItem
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository

interface CarritoRepository : JpaRepository<CarritoItem, Long> {


    fun findByUsuarioId(usuarioId: Long): List<CarritoItem>

    @Transactional
    fun deleteByUsuarioId(usuarioId: Long)
}