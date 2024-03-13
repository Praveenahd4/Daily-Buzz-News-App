package com.hd.dailybuzz.domain.usecases.news

import com.hd.dailybuzz.data.local.NewsDao
import com.hd.dailybuzz.domain.model.Article
import com.hd.dailybuzz.domain.repository.NewsRepository
import javax.inject.Inject

class GetSavedArticle @Inject constructor(
    //private val newsDao: NewsDao
    private val repository: NewsRepository
) {

    suspend operator fun invoke(id: Int): Article?{
        return repository.getArticle(id)
    }
}