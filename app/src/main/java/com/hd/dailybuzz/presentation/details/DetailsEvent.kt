package com.hd.dailybuzz.presentation.details

import com.hd.dailybuzz.domain.model.Article


sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}