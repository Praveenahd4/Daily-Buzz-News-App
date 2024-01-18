package com.hd.dailybuzz.domain.usecase

import com.hd.dailybuzz.data.model.Article
import com.hd.dailybuzz.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article)=newsRepository.deleteNews(article)
}