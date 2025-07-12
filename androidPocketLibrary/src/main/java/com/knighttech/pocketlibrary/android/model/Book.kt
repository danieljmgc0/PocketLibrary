package com.knighttech.pocketlibrary.android.model


data class Book(
    val isbn: String,
    val title: String,
    val author: String
)

// Puedes crear datos de ejemplo
object SampleData {
    val books = listOf(
        Book("9780140449136", "Odisea", "Homero"),
        Book("9788420413380", "Don Quijote de la Mancha", "Miguel de Cervantes"),
        Book("9788467037635", "Cien años de soledad", "Gabriel García Márquez")
    )
}
