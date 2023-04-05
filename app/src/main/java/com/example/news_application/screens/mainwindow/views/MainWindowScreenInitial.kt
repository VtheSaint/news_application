package com.example.news_application.screens.mainwindow.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.news_application.screens.mainwindow.MainWindowViewState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.news_application.screens.mainwindow.models.NewsCard



@Composable
fun MainWindowScreenInitialTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text("The News maker",
            style = TextStyle.Default,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            color = Color.White
        )
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainWindowScreenInitial (
    navController: NavController,
    state: MainWindowViewState.MainWindowViewStateInitial,
) {
    Scaffold(
        topBar = { MainWindowScreenInitialTopAppBar() },
        backgroundColor = Color.LightGray
    ) {
        LazyColumn(
            modifier = Modifier.background(Color.LightGray)
        ) {
            items(items = state.newsList) {
                NewsCard(data = it, navController = navController)
            }
        }
    }
}


var url = "https://i.guim.co.uk/img/media/45fb656743723caa67dd6012e61a6e8ebc7a6ca2/126_0_6277_3767/master/6277.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=6a69e835bade7428641fd21649f3f9f1"

//@Preview
//@Composable
//fun MainWindowScreenInitialPreview() {
//    MainWindowScreenInitial(
//        state = MainWindowViewState.MainWindowViewStateInitial(
//            newsList = listOf(
//                NewsModel(
//                    source = Source(
//                        id = null,
//                        name = null
//                    ),
//                    author = "MEme",
//                    title = "WWR and some more",
//                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris mattis justo sit amet sapien lacinia, vel iaculis eros aliquam. Suspendisse metus velit, faucibus varius iaculis sed, finibus at massa.",
//                    url = null,
//                    url_for_image = url,
//                    published_at = "Tomorrow",
//                    content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris mattis justo sit amet sapien lacinia, vel iaculis eros aliquam. Suspendisse metus velit, faucibus varius iaculis sed, finibus at massa. Donec in enim vestibulum, rhoncus nisl condimentum, euismod orci. Etiam turpis lorem, posuere vel felis et, dignissim hendrerit ligula. Suspendisse felis justo, dignissim ac mi quis, facilisis euismod nisi. Vestibulum aliquet, purus eu molestie lacinia, eros massa tristique risus, at vehicula dolor neque eu ex. Aenean blandit erat est, a gravida felis semper eu. Nullam venenatis a augue sit amet maximus. Aenean et orci commodo, consectetur ante auctor, egestas sapien. Sed ultrices nisl a aliquet eleifend. Phasellus et lectus sed eros elementum accumsan in ut ipsum. Quisque consectetur sollicitudin quam, eu aliquet odio vehicula malesuada. Donec hendrerit et justo ultrices lacinia. Praesent malesuada malesuada maximus. Cras vel consequat ex. Vivamus aliquet tellus a mi euismod, sit amet gravida eros tristique"
//                )
//            )
//        ),
////        navController = ""
//    )
//}