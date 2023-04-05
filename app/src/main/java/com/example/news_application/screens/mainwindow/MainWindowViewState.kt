package com.example.news_application.screens.mainwindow

import com.example.news_application.screens.mainwindow.models.NewsModel

sealed class MainWindowViewState {
    data class MainWindowViewStateInitial(
        val newsList: List<NewsModel> = listOf()
    ): MainWindowViewState()
}