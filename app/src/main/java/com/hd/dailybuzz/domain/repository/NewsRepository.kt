package com.hd.dailybuzz.domain.repository

import com.hd.dailybuzz.data.model.APIResponse
import com.hd.dailybuzz.data.model.Article
import com.hd.dailybuzz.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country:String,page:Int):Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}