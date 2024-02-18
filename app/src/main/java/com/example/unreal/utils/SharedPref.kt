package com.example.unreal.utils


import android.content.Context
import android.content.Context.MODE_PRIVATE



object SharedPref {
    fun storeData(
        email: String, name: String,
        bio: String, username: String, imageUri: String, context: Context
    ){
        val sharedPreferences = context.getSharedPreferences("users", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name",name)
        editor.putString("email",email)
        editor.putString("bio", bio)
        editor.putString("username",username)
        editor.putString("imageUri",imageUri)
        editor.apply()
    }

    fun getName(context: Context):String{
        val sharedPreferences = context.getSharedPreferences("users", MODE_PRIVATE)
        return sharedPreferences.getString("name","")!!
    }
    fun getUserName(context: Context):String{
        val sharedPreferences = context.getSharedPreferences("users", MODE_PRIVATE)
        return sharedPreferences.getString("username","")!!
    }
    fun getEmail(context: Context):String{
        val sharedPreferences = context.getSharedPreferences("users", MODE_PRIVATE)
        return sharedPreferences.getString("email","")!!
    }
    fun getBio(context: Context):String{
        val sharedPreferences = context.getSharedPreferences("users", MODE_PRIVATE)
        return sharedPreferences.getString("bio","")!!
    }
    fun getImage(context: Context):String{
        val sharedPreferences = context.getSharedPreferences("users", MODE_PRIVATE)
        return sharedPreferences.getString("imageUri","")!!
    }


}