package com.example.news_application.screens.mainwindow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news_application.base.EventHandler
import com.example.news_application.screens.mainwindow.models.NewsWindowEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainWindowViewModel @Inject constructor(): ViewModel(), EventHandler<NewsWindowEvent> {
    private val _mainWindowViewState: MutableLiveData<MainWindowViewState> =
        MutableLiveData(MainWindowViewState.MainWindowViewStateInitial())
    val mainWindowViewState: LiveData<MainWindowViewState> = _mainWindowViewState
    override fun obtainEvent(event: NewsWindowEvent) {
        when (val currentState = mainWindowViewState.value) {
            is MainWindowViewState.MainWindowViewStateInitial -> reduce(currentState, event)
            else -> {}
        }
    }

    fun reduce(currentState:MainWindowViewState, event: NewsWindowEvent) {

    }

}