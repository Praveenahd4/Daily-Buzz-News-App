package com.hd.dailybuzz.presentation.onboarding

import androidx.annotation.DrawableRes
import com.hd.dailybuzz.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Welcome to Daily Buzz!",
        description = "Get ready to stay informed and inspired with our curated selection of news articles. Daily Buzz is your gateway to the latest headlines, insightful analysis, and trending stories from around the globe.",
        image = R.drawable.dailybuzz
    ),
    Page(
        title = "Discover with Ease",
        description = "Dive into the world of news effortlessly with our powerful search feature. Explore a vast archive of articles, videos, and updates tailored to your interests. Find what matters to you, whenever you need it.",
        image = R.drawable.sky
    ),
    Page(
        title = "Save, Read, and Share",
        description = "Never miss a beat with Daily Buzz's save and share feature. Save articles to read later, bookmark your favorites, and share the latest news with friends and family at the touch of a button. Stay connected, stay informed.",
        image = R.drawable.news
    )
)