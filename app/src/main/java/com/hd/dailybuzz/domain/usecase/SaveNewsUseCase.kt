package com.hd.dailybuzz.domain.usecase

import com.hd.dailybuzz.data.model.Article
import com.hd.dailybuzz.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article)=newsRepository.saveNews(article)
}