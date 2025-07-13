package com.knighttech.pocketlibrary.books



import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import com.knighttech.pocketlibrary.books.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod


class BookService {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    /**
     * Llama a Google Books y devuelve el primer resultado, o null si no hay datos.
     */
    suspend fun fetchByIsbn(isbn: String): String? {
        println("RESPONSE " + isbn)
        val url = "https://www.googleapis.com/books/v1/volumes?q=isbn:${isbn}"
        val response: HttpResponse = client.get(url) {
            method = HttpMethod.Get
        }
        val jsonString = response.bodyAsText()
        println("RESPONSE ${jsonString}")
        // El bodyAsText() te da el JSON completo como String
        return response.bodyAsText()
    }
}