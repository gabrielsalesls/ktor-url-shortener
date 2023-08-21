package gabrielsalesls.github.io.database

import gabrielsalesls.github.io.model.UrlTable
import io.ktor.server.config.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init(config: ApplicationConfig) {
        val driverClassName = config.property("database.driverClassName").getString()
        val url = config.property("database.url").getString()
        val user = config.property("database.user").getString()
        val password = config.property("database.password").getString()

        val database = Database.connect(
            url = url,
            driver = driverClassName,
            user = user,
            password = password
        )
        transaction(database) {
            SchemaUtils.create(UrlTable)
        }
    }
}
