package com.example.news_application.screens.mainwindow.models

import java.net.URL

class Source (
    id: String?,
    name: String?
)

class NewsModel(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: URL?,
    val url_for_image: String?,
    val published_at: String,
    val content: String,
)