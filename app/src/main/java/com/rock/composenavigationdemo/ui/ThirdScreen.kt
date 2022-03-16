package com.rock.composenavigationdemo.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ThirdScreen(navController: NavController,arg1:String,arg2:Int){
    Scaffold {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "ThirdScreen")
            Text(text = "$arg1")
            Text(text = "arg2:$arg2 , type: ${arg2::class.java}")
            //导航到 Fourth
            Button(onClick = { navController.navigate(Screen.Fourth.route){
//                //将 back 栈 pop 到 First
//                popUpTo(route = Screen.First.route)
                // inclusive = ture ， route 参数指定的路由也会被弹出
                popUpTo(route = Screen.Second.route){ inclusive = true }
            } }) {
                Text(text = "Go Fourth Screen popUpTo First")
            }
        }
    }
}