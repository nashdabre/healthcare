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
import com.example.unreal.screens.Doctor
import com.example.unreal.screens.Home
import com.example.unreal.screens.Login
import com.example.unreal.screens.Notifications
import com.example.unreal.screens.Profile
import com.example.unreal.screens.Register
import com.example.unreal.screens.Settings
import com.example.unreal.screens.Splash
import com.example.unreal.screens.articel

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController= navController,
        startDestination = Routes.Splash.routes){

        composable(Routes.Splash.routes){
            Splash(navController)
        }

        composable(Routes.Home.routes){
            Home(navController)//navController
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
        composable(Routes.BottomNav.routes){
            BottomNav(navController)
        }
        composable(Routes.Login.routes){
            Login(navController)
        }
        composable(Routes.Doctor.routes){
            Doctor(navController)
        }
        composable(Routes.Aritcel.routes){
            articel(navController)
        }
        composable(Routes.Register.routes){
            Register(navController)
        }
    }
}