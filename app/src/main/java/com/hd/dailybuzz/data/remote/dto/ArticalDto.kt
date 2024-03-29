package com.hd.dailybuzz.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.hd.dailybuzz.domain.model.Article
import com.hd.dailybuzz.domain.model.Source

data class ArticleDto(
    @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String
)

fun ArticleDto.toArticle(): Article {
    return Article(
        author = author,
        description = description,
        publishedAt = publishedAt,
        source = source,
        title = title,
        content = content,
        url = url,
        urlToImage = urlToImage,
        id = 0
    )
}