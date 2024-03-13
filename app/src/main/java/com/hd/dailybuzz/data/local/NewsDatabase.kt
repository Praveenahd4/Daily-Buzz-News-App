package com.hd.dailybuzz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hd.dailybuzz.domain.model.Article

@Database(entities = [Article::class],version = 4, exportSchema = false)
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao: NewsDao

}