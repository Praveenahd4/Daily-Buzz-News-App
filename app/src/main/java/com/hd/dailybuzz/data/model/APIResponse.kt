package com.hd.dailybuzz.data.model

data class APIResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)