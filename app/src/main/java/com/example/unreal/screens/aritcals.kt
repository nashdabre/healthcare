package com.example.unreal.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unreal.R
import com.example.unreal.navigation.Routes
import androidx.navigation.NavHostController



@Composable
fun articel(navHostController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(color = Color(android.graphics.Color.parseColor("#ede7f8")))
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .height(50.dp)
                .width(65.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#7868e5")),
                    shape = RoundedCornerShape(20.dp)
                )

        ) {
            Image(
                painter = painterResource(id = R.drawable.leftarrow),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navHostController.navigate(Routes.BottomNav.routes) {
                            popUpTo(navHostController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Column(
                Modifier
                    .weight(0.5f)
                    .padding(end = 12.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.snake),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                        ), contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Snake bite",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#7869e5"))
                    )
                }
            }
            /* Column(
            Modifier
                .weight(0.5f)
                .padding(end = 12.dp)
                .background(
                    color = androidx.compose.ui.graphics.Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(65.dp)
                    .width(75.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#7868e5")),
                        shape = RoundedCornerShape(20.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.trolley),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(7.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(40.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                        shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Buy Medicine",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(android.graphics.Color.parseColor("#7869e5"))
                )
            }*/

            Column(
                Modifier
                    .weight(0.5f)
                    .padding(end = 12.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hospital),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Awareness",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#7869e5"))
                    )
                }
            }
        }
    }
}