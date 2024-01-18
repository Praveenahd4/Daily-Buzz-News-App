package com.hd.dailybuzz.domain.usecase

import com.hd.dailybuzz.data.model.APIResponse
import com.hd.dailybuzz.data.util.Resource
import com.hd.dailybuzz.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery:String): Resource<APIResponse>{
        return newsRepository.getSearchedNews(searchQuery)
    }
}