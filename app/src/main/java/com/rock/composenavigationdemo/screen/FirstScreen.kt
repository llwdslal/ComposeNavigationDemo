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
fun FirstScreen(navController: NavController){
    Scaffold {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "FirstScreen")
            //navController.navigate() 跳转到指定路由
            //指定的路由必须在 NavGraph 中可以找到，不然会抛 IllegalArgumentException 异常
            Button(onClick = { navController.navigate("SecondScreen") }) {
                Text(text = "Go Second Screen")
            }
        }
    }
}