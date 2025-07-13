package com.knighttech.pocketlibrary.books


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GoogleBooksResponse(
    val items: List<Volume> = emptyList()
)

@Serializable
data class Volume(
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String> = emptyList(),
    @SerialName("publisher") val publisher: String? = null,
    @SerialName("publishedDate") val publishedDate: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("imageLinks") val imageLinks: ImageLinks? = null,
    @SerialName("industryIdentifiers") val industryIdentifiers: String? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = null
)