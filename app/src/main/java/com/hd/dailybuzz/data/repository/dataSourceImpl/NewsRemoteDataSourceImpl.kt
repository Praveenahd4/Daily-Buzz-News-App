package com.hd.dailybuzz.data.repository.dataSourceImpl

import com.hd.dailybuzz.data.api.NewsAPIService
import com.hd.dailybuzz.data.model.APIResponse
import com.hd.dailybuzz.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country:String,page:Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country,page)
    }
}