package gabrielsalesls.github.io

import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
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


    }
}
