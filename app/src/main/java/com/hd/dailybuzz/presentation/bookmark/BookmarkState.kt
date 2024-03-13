package com.hd.dailybuzz.presentation.bookmark

import com.hd.dailybuzz.domain.model.Article


data class BookmarkState(
    val articles: List<Article> = emptyList(),
    val isDelete:Boolean = false,
    val toast: String=""
)