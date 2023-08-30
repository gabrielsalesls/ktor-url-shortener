package gabrielsalesls.github.io

import gabrielsalesls.github.io.model.request.UrlRequest
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import org.junit.Assert
import org.junit.Test


class ApplicationTest {
    @Test
    fun testApp() = testApplication {
        environment {
            config = ApplicationConfig("application-test.conf")
        }

        val client = createClient {
            install(ContentNegotiation) {
                gson()
            }
            followRedirects = true
        }

        client.post("/") {
            contentType(ContentType.Application.Json)
            setBody(UrlRequest("www.google.com"))
        }.let {
            println(it.bodyAsText())
            Assert.assertTrue(it.bodyAsText().contains("google"))
            Assert.assertEquals(HttpStatusCode.Created.value, it.status.value)
        }

        client.get("/123") {
            contentType(ContentType.Application.Json)
        }.let {
            Assert.assertEquals(HttpStatusCode.NotFound.value, it.status.value)
        }

    }
}
