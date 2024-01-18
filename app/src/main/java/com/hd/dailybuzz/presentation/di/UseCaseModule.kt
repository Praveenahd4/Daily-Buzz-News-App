package com.hd.dailybuzz.presentation.di

import com.hd.dailybuzz.domain.repository.NewsRepository
import com.hd.dailybuzz.domain.usecase.GetNewsHeadlinesUseCase
import dagger.Provides
import javax.inject.Singleton

class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetNewsHeadLinesUseCase(newsRepository: NewsRepository): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }
}