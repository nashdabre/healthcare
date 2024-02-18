package com.example.unreal.screens


import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextButton
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

import com.example.unreal.R
import com.example.unreal.navigation.Routes
import com.example.unreal.viewmodel.AuthViewModel
import com.google.protobuf.Empty

val  visualTransformation = PasswordVisualTransformation()
@Composable
fun Register(navController:NavHostController){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var bio by remember {
        mutableStateOf("")
    }
    var username by remember {
        mutableStateOf("")
    }
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    fun Context.doLogin() {
        Toast.makeText(
            this,
            "Something went wrong, try again later!",
            Toast.LENGTH_SHORT
        ).show()
    }


    val focusManager = LocalFocusManager.current
    val authViewModel: AuthViewModel = viewModel()
    val firebaseUser by authViewModel.firebaseUser.observeAsState(null)

    val permission = if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.TIRAMISU){
        android.Manifest.permission.READ_MEDIA_IMAGES
    }else android.Manifest.permission.READ_EXTERNAL_STORAGE

    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()){
        uri: Uri? -> imageUri = uri
    }

    val permissionlauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()){

            isGranted: Boolean ->
            if(isGranted){

            }else{

            }
        }

    LaunchedEffect(firebaseUser) {
          if(firebaseUser!=null){
            navController.navigate(Routes.Login.routes) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }
    }



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Register Here", style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start
                )
            )

            Box(modifier = Modifier.height(25.dp))

            Image(painter =if (imageUri == null) painterResource(id = R.drawable.person)
                else rememberAsyncImagePainter(model = imageUri)
            , contentDescription = "person",
                modifier= Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .clickable {

                        val isGranted = ContextCompat.checkSelfPermission(
                            context, permission
                        ) == PackageManager.PERMISSION_GRANTED

                        if (isGranted) {
                            launcher.launch("image/*")
                        } else {
                            permissionlauncher.launch(permission)
                        }

                    }, contentScale = ContentScale.Crop)


            Box(modifier = Modifier.height(25.dp))
            OutlinedTextField(value = name, onValueChange = { name = it }, label = {
                androidx.compose.material.Text(text = "Name")
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ), singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            )
            OutlinedTextField(value = email, onValueChange = { email = it }, label = {
                androidx.compose.material.Text(text = "Email")
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ), singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            )
            OutlinedTextField(value = bio, onValueChange = { bio = it }, label = {
                androidx.compose.material.Text(text = "Bio")
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ), singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            )
            OutlinedTextField(value = username, onValueChange = { username = it }, label = {
                androidx.compose.material.Text(text = "Username")
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ), singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            )
            OutlinedTextField(value = password, onValueChange = { password = it }, label = {
                androidx.compose.material.Text(text = "Password")
            },keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
                context.doLogin() /*keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password*/
            } ), visualTransformation = visualTransformation, singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            )


            Box(modifier = Modifier.height(30.dp))
            ElevatedButton(onClick = {
                if(name.isEmpty()||email.isEmpty()||bio.isEmpty()||username.isEmpty()||password.isEmpty()){
                    Toast.makeText(context,"Please fill all details", Toast.LENGTH_SHORT).show()
                }
                else{
                    authViewModel.register(email, password, name, bio, username, imageUri!!,context)
                    navController.navigate(Routes.Login.routes) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }

            }, modifier = Modifier.fillMaxWidth()) {
                androidx.compose.material.Text(
                    text = "Register", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,

                        ), modifier = Modifier.padding(vertical = 6.dp)
                )

            }

            TextButton(
                onClick = {
                    navController.navigate(Routes.Login.routes) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                androidx.compose.material.Text(
                    text = "Already Registered? Login here",
                    style = TextStyle(fontSize = 16.sp)
                )


            }

        }

    }


