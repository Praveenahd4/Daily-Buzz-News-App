package com.hd.dailybuzz.presentation.di

import android.app.Application
import androidx.room.Room
import com.hd.dailybuzz.data.api.NewsAPIService
import com.hd.dailybuzz.data.repository.dataSource.NewsRemoteDataSource
import com.hd.dailybuzz.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDatabase(newsAPIService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}