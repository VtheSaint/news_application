package com.example.news_application.screens.mainwindow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_application.base.EventHandler
import com.example.news_application.data.network.ApiService
import com.example.news_application.screens.mainwindow.models.NewsWindowEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainWindowViewModel @Inject constructor(): ViewModel(), EventHandler<NewsWindowEvent> {
    private var _mainWindowViewState: MutableLiveData<MainWindowViewState> =
        MutableLiveData(MainWindowViewState.MainWindowViewStateInitial())
    val mainWindowViewState: LiveData<MainWindowViewState> = _mainWindowViewState
    override fun obtainEvent(event: NewsWindowEvent) {
        when (val currentState = mainWindowViewState.value) {
            is MainWindowViewState.MainWindowViewStateInitial -> reduce(currentState, event)
            else -> {}
        }
    }


    fun getNews() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val newsList = apiService.getNews()
                obtainEvent(NewsWindowEvent.Get(newsList))
                println(newsList)
            } catch (e: Exception) {
                println(e.message.toString())
            }
        }
    }
    fun reduce(currentState: MainWindowViewState.MainWindowViewStateInitial, event: NewsWindowEvent) {
        when (event) {
            is NewsWindowEvent.Get -> _mainWindowViewState.postValue(
                currentState.copy(
                    newsList = event.news
                )
            )
        }
    }

}