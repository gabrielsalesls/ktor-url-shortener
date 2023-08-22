package gabrielsalesls.github.io.model.entity

import gabrielsalesls.github.io.model.response.UrlResponse
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

data class Url(val originalUrl: String, val urlCode: String)

fun Url.toResponse(): UrlResponse {
    return UrlResponse(
        originalUrl = originalUrl,
        shortUrl = "http://localhost:8080/$urlCode")
}

object UrlTable : Table() {
    val originalUrl = text("original_url")
    val urlCode = varchar("url_code", 6)

    override val primaryKey = PrimaryKey(urlCode)

    fun ResultRow.toUrl(): Url = Url(
        originalUrl = this[originalUrl],
        urlCode = this[urlCode]
    )
}
