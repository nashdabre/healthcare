package com.example.unreal.navigation

 sealed class Routes(val routes:String) {
     object  Splash: Routes("splash")
     object  Home: Routes("home")
     object  Profile: Routes("profile")
     object  Notification: Routes("notificaton")
     object  Settings: Routes("settings")
     object BottomNav: Routes("bottom_nav")
     object dropDownMenu: Routes("dropdownmenu")
     object Login: Routes("login")
     object Register: Routes("register")

     object Doctor: Routes("doctor")
     object Aritcel: Routes("articel")

}