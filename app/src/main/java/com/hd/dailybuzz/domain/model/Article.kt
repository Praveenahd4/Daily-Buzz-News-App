package com.hd.dailybuzz.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null,
    val content: String? = null,
    val title: String,
    val url: String? = null,
    val urlToImage: String? = null,
    val isSaved : Boolean = false
) : Parcelable