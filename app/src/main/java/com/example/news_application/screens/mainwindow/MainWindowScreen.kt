package com.example.news_application.screens.mainwindow

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.runtime.livedata.observeAsState
import com.example.news_application.screens.mainwindow.views.MainWindowScreenInitial


@Composable
fun MainWindowScreen(
    navController: NavController,
    viewModel: MainWindowViewModel
) {
    val viewState = viewModel.mainWindowViewState.observeAsState(initial = viewModel.getNews())
    when (val state = viewState.value) {
        is MainWindowViewState.MainWindowViewStateInitial -> MainWindowScreenInitial(
            state = state,
            navController = navController
        )
    }
}