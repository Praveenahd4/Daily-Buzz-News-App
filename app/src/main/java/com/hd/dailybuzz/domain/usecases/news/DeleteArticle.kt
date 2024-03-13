package com.hd.dailybuzz.domain.usecases.news

import com.hd.dailybuzz.domain.model.Article
import com.hd.dailybuzz.domain.repository.NewsRepository
import javax.inject.Inject

class DeleteArticle @Inject constructor(
//    private val newsDao: NewsDao
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }

}