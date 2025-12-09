package apptienda.apptienda_api.repository

import apptienda.apptienda_api.model.Resenia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ReseniaRepository  : JpaRepository<Resenia, Int> {


    fun findByCodigo(codigo: String): List<Resenia>
}