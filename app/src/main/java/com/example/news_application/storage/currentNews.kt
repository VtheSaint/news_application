package com.example.news_application.storage

import com.example.news_application.screens.mainwindow.models.NewsModel
import com.example.news_application.screens.mainwindow.models.Source

var currentNews: NewsModel = NewsModel(
    source = Source(
        id = null,
        name = null,
    ),
    author = null,
    title = "",
    description = "",
    url = null,
    url_for_image = null,
    published_at = "",
    content = ""

)