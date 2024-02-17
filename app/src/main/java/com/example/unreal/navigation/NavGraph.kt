package com.example.unreal.navigation

import android.app.Notification
import android.provider.ContactsContract
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.unreal.screens.BottomNav
import com.example.unreal.screens.Home
import com.example.unreal.screens.Notifications
import com.example.unreal.screens.Profile
import com.example.unreal.screens.Settings
import com.example.unreal.screens.Splash

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController= navController,
        startDestination = Routes.Splash.routes){

        composable(Routes.Splash.routes){
            Splash(navController)
        }
        composable(Routes.Home.routes){
            Home()
        }
        composable(Routes.Profile.routes){
            Profile()
        }
        composable(Routes.Notification.routes){
            Notifications()
        }
        composable(Routes.Settings.routes){
            Settings()
        }
        composable(Routes.BottomNav.routes){
            BottomNav(navController)
        }
    }
}