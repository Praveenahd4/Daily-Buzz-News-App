package com.hd.dailybuzz.domain.usecases.news

import com.hd.dailybuzz.data.local.NewsDao
import com.hd.dailybuzz.domain.model.Article
import com.hd.dailybuzz.domain.repository.NewsRepository
import javax.inject.Inject

class UpsertArticle @Inject constructor(
//    private val newsDao: NewsDao
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticle(article = article)
    }

}