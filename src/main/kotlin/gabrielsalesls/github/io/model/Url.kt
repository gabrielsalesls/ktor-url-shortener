package gabrielsalesls.github.io.model

import org.jetbrains.exposed.sql.Table

data class Url(val originalUrl: String, val shortUrl: String)

object UrlTable : Table() {
    val originalUrl = text("original_url")
    val shortUrl = text("short_url")

    override val primaryKey = PrimaryKey(shortUrl)
}
