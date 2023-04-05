package com.example.news_application.screens.mainwindow.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.news_application.storage.currentNews

@Composable
fun NewsCard (
    data: NewsModel,
    navController: NavController
) {
    Card(
        backgroundColor = Color.White,
        shape = RoundedCornerShape(4.dp),
        contentColor = Color.Black,
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .clickable {
                currentNews = data
                navController.navigate("Read")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = data.title, fontSize = 20.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    if (data.author != null) {
                        Text(text = data.author.toString())
                    }
                    Text(text = data.published_at)

                }
            }
            if (data.url_for_image != null) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = data.url_for_image),
                        contentDescription = null,
                        modifier = Modifier.size(256.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "       " + data.description, fontSize = 12.sp)
            }

        }



    }

}