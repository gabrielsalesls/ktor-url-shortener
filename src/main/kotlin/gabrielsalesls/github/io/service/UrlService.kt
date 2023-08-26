package gabrielsalesls.github.io.service

import gabrielsalesls.github.io.model.entity.Url
import gabrielsalesls.github.io.repository.UrlRepository
import java.util.*

class UrlService(val repository: UrlRepository) {

    suspend fun save(url: String): Url {

        val urlCode = generateUrlCode()

        val urlModel = Url(url, urlCode)

        val response = repository.save(urlModel)
        return response.first()
    }

    suspend fun getOriginalUrl(urlCode: String): String {
        val url = repository.findByUrlCode(urlCode).originalUrl

        return if (!url.startsWith("https://")) {
            "https://$url"
        } else {
            url
        }
    }
}

private fun generateUrlCode() = UUID.randomUUID().toString().substring(0, 6)
