package gabrielsalesls.github.io.model.response

import kotlinx.serialization.Serializable

@Serializable
class UrlResponse(
    val originalUrl: String,
    val shortUrl: String
)