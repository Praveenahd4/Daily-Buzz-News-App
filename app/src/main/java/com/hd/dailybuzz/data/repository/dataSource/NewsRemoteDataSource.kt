package com.hd.dailybuzz.data.repository.dataSource

import com.hd.dailybuzz.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country:String, page: Int): Response<APIResponse>
}