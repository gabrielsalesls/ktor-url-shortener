package gabrielsalesls.github.io

import gabrielsalesls.github.io.database.DatabaseFactory
import gabrielsalesls.github.io.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init(environment.config)
    configureSerialization()
}
