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
            Button(onClick = { navController.navigate(Screen.First.route) }) {
                Text(text = "Go First Screen")
            }
        }
    }
}