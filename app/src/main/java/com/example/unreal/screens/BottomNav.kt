package com.example.unreal.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.unreal.R
import com.example.unreal.navigation.Routes

@Composable
fun BottomNav(navController: NavHostController){
    val navController1 = rememberNavController()

    androidx.compose.material.Scaffold (bottomBar ={ BottomBar(navController1)}){

        innerPadding -> NavHost(navController = navController1, startDestination = Routes.Home.routes,
            modifier = Modifier.padding(innerPadding)){
            composable(route = Routes.Home.routes){
                Home(navController)//navController
            }
        composable(route = Routes.Doctor.routes){
            Doctor(navController)//navController
        }
        composable(route = Routes.Aritcel.routes){
            articel(navController)//navController
        }
        composable(Routes.Profile.routes){
            Profile(navController)
        }
        composable(Routes.Notification.routes){
            Notifications()
        }
        composable(Routes.Settings.routes){
            Settings()
        }
    }

    }
}
data class BottomMenuItem(val label:String, val icon: Painter, val route:String) {

}


@Composable
fun prepareBottomMenu(): List<BottomMenuItem>{
    val bottomMenuItemList= arrayListOf<BottomMenuItem>()

    bottomMenuItemList.add(BottomMenuItem(label = "Home", icon = painterResource(id = R.drawable.bottom_btn1),route = Routes.Home.routes))
    bottomMenuItemList.add(BottomMenuItem(label = "Profile", icon = painterResource(id = R.drawable.bottom_btn2),route = Routes.Profile.routes))
    bottomMenuItemList.add(BottomMenuItem(label = "Notification", icon = painterResource(id = R.drawable.bottom_btn3),route = Routes.Notification.routes))
    bottomMenuItemList.add(BottomMenuItem(label = "Setting", icon = painterResource(id = R.drawable.bottom_btn4),route = Routes.Settings.routes))

    return bottomMenuItemList
}


@Composable
fun BottomBar(navController1: NavHostController) {

    val backStackEntry = navController1.currentBackStackEntryAsState()
    val bottomMenuItemList = prepareBottomMenu()



    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(40.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
            ),
        containerColor = Color.White, tonalElevation = 3.dp
    ) {

        bottomMenuItemList.forEach{
            val selected = it.route == backStackEntry?.value?.destination?.route

            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController1.navigate(it.route){
                        popUpTo(navController1.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = it.icon,
                        contentDescription = null,
                        modifier = Modifier
                            .height(22.dp)
                            .width(30.dp)
                            //.padding(start= 10.dp,bottom = 6.dp)

                    )
                },
               label = {
                   Text(text = it.label, modifier = Modifier.padding(top = 16.dp))
                },
                alwaysShowLabel = true,
                enabled = true
            )
        }



        }


}

