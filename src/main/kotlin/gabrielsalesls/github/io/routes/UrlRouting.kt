package gabrielsalesls.github.io.routes

import gabrielsalesls.github.io.model.entity.toResponse
import gabrielsalesls.github.io.model.request.UrlRequest
import gabrielsalesls.github.io.service.UrlService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    service: UrlService
) {
    routing {
        post("/") {
            val urlRequest = call.receive<UrlRequest>()

            val response = service.save(urlRequest.name).toResponse()

            return@post call.respond(
                status = HttpStatusCode.Created,
                message = response
            )
        }
        get("/{code}") {
            val urlCode = call.parameters["code"] ?: throw IllegalArgumentException("Code cannot be null")

            val urlToRedirect = service.getOriginalUrl(urlCode)

            call.respondRedirect(urlToRedirect)
        }
    }

}