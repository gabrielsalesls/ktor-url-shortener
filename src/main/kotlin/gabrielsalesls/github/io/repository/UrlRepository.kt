package gabrielsalesls.github.io.repository

import gabrielsalesls.github.io.database.DatabaseFactory.dbQuery
import gabrielsalesls.github.io.model.entity.Url
import gabrielsalesls.github.io.model.entity.UrlTable
import gabrielsalesls.github.io.model.entity.UrlTable.toUrl
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class UrlRepository {

    suspend fun save(url: Url): List<Url> {
        val urlSaved = dbQuery {
            UrlTable.insert {
                it[originalUrl] = url.originalUrl
                it[urlCode] = url.urlCode
            }
        }
        return urlSaved.resultedValues?.map { it.toUrl() }
            ?: throw Exception("Erro ao salvar URL") // criar exception propria
    }

    suspend fun findByUrlCode(urlCode: String): Url {
        val originalUrl = dbQuery {
            UrlTable.select { UrlTable.urlCode eq urlCode }.firstOrNull()
        } ?: throw NoSuchElementException("Codigo não encontrado")

        return originalUrl.toUrl()
    }
}