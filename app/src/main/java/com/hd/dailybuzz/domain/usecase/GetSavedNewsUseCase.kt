package com.hd.dailybuzz.domain.usecase

import com.hd.dailybuzz.data.model.Article
import com.hd.dailybuzz.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}