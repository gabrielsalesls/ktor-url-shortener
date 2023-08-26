package gabrielsalesls.github.io

import gabrielsalesls.github.io.database.DatabaseFactory
import gabrielsalesls.github.io.plugins.configureSerialization
import gabrielsalesls.github.io.plugins.configureStatusPage
import gabrielsalesls.github.io.repository.UrlRepository
import gabrielsalesls.github.io.routes.configureRouting
import gabrielsalesls.github.io.service.UrlService
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init(environment.config)
    configureSerialization()

    val urlRepository = UrlRepository()
    val urlService = UrlService(urlRepository)

    configureRouting(urlService)
    configureStatusPage()
}
