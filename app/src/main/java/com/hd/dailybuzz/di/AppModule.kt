package com.hd.dailybuzz.di

import android.app.Application
import androidx.room.Room
import com.hd.dailybuzz.data.local.NewsDao
import com.hd.dailybuzz.data.local.NewsDatabase
import com.hd.dailybuzz.data.local.NewsTypeConvertor
import com.hd.dailybuzz.data.manger.LocalUserMangerImpl
import com.hd.dailybuzz.data.remote.NewsApi
import com.hd.dailybuzz.domain.manger.LocalUserManger
import com.hd.dailybuzz.domain.repository.NewsRepository
import com.hd.dailybuzz.domain.usecases.app_entry.AppEntryUseCases
import com.hd.dailybuzz.domain.usecases.app_entry.ReadAppEntry
import com.hd.dailybuzz.domain.usecases.app_entry.SaveAppEntry
import com.hd.dailybuzz.domain.usecases.news.DeleteArticle
import com.hd.dailybuzz.domain.usecases.news.GetNews
import com.hd.dailybuzz.domain.usecases.news.GetSavedArticle
import com.hd.dailybuzz.domain.usecases.news.GetSavedArticles
import com.hd.dailybuzz.domain.usecases.news.NewsUseCases
import com.hd.dailybuzz.domain.usecases.news.SearchNews
import com.hd.dailybuzz.domain.usecases.news.UpsertArticle
import com.hd.dailybuzz.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            getArticles = GetSavedArticles(newsRepository),
            getArticle = GetSavedArticle(newsRepository)
        )
    }
}