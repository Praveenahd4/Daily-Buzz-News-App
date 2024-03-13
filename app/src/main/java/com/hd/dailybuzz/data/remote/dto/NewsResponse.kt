package com.hd.dailybuzz.data.remote.dto

import com.hd.dailybuzz.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String?,
    val totalResults: Int?
)
