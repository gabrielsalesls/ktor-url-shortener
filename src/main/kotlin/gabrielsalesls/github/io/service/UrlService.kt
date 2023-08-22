package gabrielsalesls.github.io.service

import gabrielsalesls.github.io.model.entity.Url
import gabrielsalesls.github.io.repository.UrlRepository
import java.util.*

class UrlService(val repository: UrlRepository) {

    suspend fun save(url: String): Url {

        val urlCode = generateUrlCode()
        //TODO: Verificar se esse codigo já esta presente no banco de dados

        val urlModel = Url(url, urlCode)

        val response = repository.save(urlModel)
        return response.first()
    }
}

private fun generateUrlCode() = UUID.randomUUID().toString().substring(0, 6)
