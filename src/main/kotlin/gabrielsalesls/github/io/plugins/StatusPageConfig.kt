package gabrielsalesls.github.io.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPage() {
    install(StatusPages) {
        exception<NoSuchElementException> { call, cause ->
            call.respondText(text = "${cause.message}", status = HttpStatusCode.NotFound)
        }
    }
}
