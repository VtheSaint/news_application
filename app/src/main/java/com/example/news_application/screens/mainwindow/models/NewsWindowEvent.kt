package com.example.news_application.screens.mainwindow.models


sealed class NewsWindowEvent {
    data class Get(val news: List<NewsModel>): NewsWindowEvent()
}
