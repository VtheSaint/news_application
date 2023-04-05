package com.example.news_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news_application.screens.mainwindow.MainWindowScreen
import com.example.news_application.screens.mainwindow.MainWindowViewModel
import com.example.news_application.screens.mainwindow.MainWindowViewState
import com.example.news_application.screens.mainwindow.models.NewsModel
import com.example.news_application.screens.mainwindow.views.MainWindowScreenInitial
import com.example.news_application.screens.mainwindow.views.NewsContentScreen
import com.example.news_application.storage.currentNews
import com.example.news_application.ui.theme.News_applicationTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            News_applicationTheme {
                MainView()
            }
        }
    }
}




@Composable
fun MainView (
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Main") {
        composable("Main") {
            val viewModel = hiltViewModel<MainWindowViewModel>(ViewModelStoreOwner { ViewModelStore() })
            MainWindowScreen(navController = navController, viewModel = viewModel)
        }
        composable("Read") {
            NewsContentScreen(data = currentNews, navController = navController)
        }
    }
}


data class BottomNavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)


