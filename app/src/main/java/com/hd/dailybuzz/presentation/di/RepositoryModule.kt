package com.hd.dailybuzz.presentation.di

import com.hd.dailybuzz.data.repository.NewsRepositoryImpl
import com.hd.dailybuzz.data.repository.dataSource.NewsRemoteDataSource
import com.hd.dailybuzz.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule() {

    @Provides
    @Singleton
    fun providesNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}
