package com.example.news_application.screens.mainwindow.models


sealed class NewsWindowEvent {
    data class DefaultE(val news: NewsModel): NewsWindowEvent()
}
