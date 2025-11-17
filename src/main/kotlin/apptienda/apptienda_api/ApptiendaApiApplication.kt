package apptienda.apptienda_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication


class ApptiendaApiApplication

fun main(args: Array<String>) {
	runApplication<ApptiendaApiApplication>(*args)
}
