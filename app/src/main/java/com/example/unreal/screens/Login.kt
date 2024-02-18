package com.example.unreal.screens
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import android.content.Context
import android.text.InputType
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import com.example.unreal.LanguageViewModel
import com.example.unreal.R
import com.example.unreal.navigation.DataStorePreferencesRepository
import com.example.unreal.navigation.Routes
import com.example.unreal.viewmodel.AuthViewModel
import java.util.Locale

/*@Composable
fun dropDownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Kotlin", "Java", "Dart", "Python")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = {Text("Label")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(30.dp)
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

}*/
/*
@Composable
fun dropDownMenu(languages: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedLanguage,
            onValueChange = { selectedLanguage = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text("Select Language") },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(20.dp)
        ) {
            languages.forEach { language ->
                DropdownMenuItem(onClick = {
                    selectedLanguage = language
                    expanded = false
                }) {
                    Text(text = language)
                }
            }
        }
    }
}*/




@Composable
fun Login(navHostController: NavHostController){
    val  visualTransformation = PasswordVisualTransformation()
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
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
  //  val error by authViewModel.error.observeAsState(null)
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

            Image(
                painter = painterResource(id = R.drawable.login_image),
                contentDescription = "login",
                modifier = Modifier
                    .fillMaxWidth()
                    .width(100.dp)
                    .height(260.dp)
                    .padding(10.dp)
            )}

        }

        LaunchedEffect(firebaseUser) {
            if (firebaseUser != null) {
                navHostController.navigate(Routes.BottomNav.routes) {
                    popUpTo(navHostController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        }



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = "Login",
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,

                    ),
                // modifier = Modifier.height( 10.dp)
            )

            Box(modifier = Modifier.height(30.dp))
            OutlinedTextField(value = email, onValueChange = { email = it }, label = {
                Text(text = "Email")
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ), singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            )
            OutlinedTextField(value = password, onValueChange = { password = it }, label = {
                Text(text = "Password")
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
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(context, "Please fill all details", Toast.LENGTH_SHORT).show()
                } else {
                    authViewModel.login(email, password, context)
                    navHostController.navigate(Routes.BottomNav.routes) {
                        popUpTo(navHostController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }


            }, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Login", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,

                        ), modifier = Modifier.padding(vertical = 6.dp)
                )

            }

            TextButton(
                onClick = {
                    navHostController.navigate(Routes.Register.routes) {
                        popUpTo(navHostController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "New User? Create Account",
                    style = TextStyle(fontSize = 16.sp)
                )


            }

        }
    }
    }

