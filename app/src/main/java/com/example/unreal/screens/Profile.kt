package com.example.unreal.screens


import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import coil.compose.rememberAsyncImagePainter
import com.example.unreal.navigation.Routes
import com.example.unreal.utils.SharedPref
import com.example.unreal.viewmodel.AuthViewModel
import org.w3c.dom.Text

@Composable
fun Profile(navHostController: NavHostController){

    val context = LocalContext.current
    ConstraintLayout(modifier= Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        val(text,logo,username,followers,following) = createRefs()
        Text(
            text = SharedPref.getName(context), style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            ),
            modifier = Modifier.constrainAs(text){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
              //  bottom.linkTo(parent.bottom)
            }
        )

        Image(painter = rememberAsyncImagePainter(model = SharedPref.getImage(context)),
            contentDescription = "close",
            modifier = Modifier
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .size(36.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = SharedPref.getUserName(context), style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier.constrainAs(username){
                top.linkTo(text.bottom)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        )
        Text(
            text = SharedPref.getBio(context), style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier.constrainAs(username){
                top.linkTo(username.bottom)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        )


    }
}