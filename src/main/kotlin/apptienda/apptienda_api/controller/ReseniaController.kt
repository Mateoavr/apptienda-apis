package apptienda.apptienda_api.controller

import apptienda.apptienda_api.model.Resenia
import apptienda.apptienda_api.repository.ReseniaRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/resenias")
@CrossOrigin(origins = ["*"])

class ReseniaController (private val repository: ReseniaRepository) {

    @PostMapping
    fun crearResenia(@RequestBody resenia: Resenia): Resenia {
        println("Recibiendo reseña: $resenia")
        return repository.save(resenia)
    }

    @GetMapping
    fun obtenerTodas(): List<Resenia> {
        return repository.findAll()
    }
}