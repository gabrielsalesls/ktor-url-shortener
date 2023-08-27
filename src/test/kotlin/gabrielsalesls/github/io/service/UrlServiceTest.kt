package gabrielsalesls.github.io.service

import gabrielsalesls.github.io.model.entity.Url
import gabrielsalesls.github.io.repository.UrlRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UrlServiceTest {

    @MockK
    private lateinit var repository: UrlRepository

    @InjectMockKs
    private lateinit var service: UrlService

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `save url code in database`() {
        runBlocking {

            val originalURL = "www.example.com"

            val expected = listOf(
                Url(originalUrl = originalURL, urlCode = "123ABCS")
            )

            coEvery { repository.save(any()) } returns expected

            val result = service.save(originalURL)
            Assert.assertEquals(originalURL, result.originalUrl)

        }
    }

    @Test
    fun `return original url from code`() {
        runBlocking {

            val originalURL = "https://www.example.com"

            val expected = Url(originalUrl = originalURL, urlCode = "123ABCS")

            coEvery { repository.findByUrlCode(any()) } returns expected

            val result = service.getOriginalUrl(originalURL)
            Assert.assertEquals(originalURL, result)
            Assert.assertTrue(result.startsWith("https://"))

        }
    }

    @Test
    fun `return original url with https`() {
        runBlocking {

            val originalURL = "www.example.com"

            val expected = Url(originalUrl = originalURL, urlCode = "123ABCS")

            coEvery { repository.findByUrlCode(any()) } returns expected

            val result = service.getOriginalUrl(originalURL)
            Assert.assertTrue(result.startsWith("https://"))

        }
    }
}