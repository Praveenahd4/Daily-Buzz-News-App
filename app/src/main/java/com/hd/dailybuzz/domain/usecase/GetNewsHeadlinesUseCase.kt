package com.hd.dailybuzz.domain.usecase

import com.hd.dailybuzz.data.model.APIResponse
import com.hd.dailybuzz.data.util.Resource
import com.hd.dailybuzz.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository){
    suspend fun execute(country:String,page:Int): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines(country,page)
    }
}