package com.rock.composenavigationdemo.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController){
    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = "Second")},
            //navController.navigateUp() 返回上一级路由
            navigationIcon = { IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }}
        ) }
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "SecondScreen")
            Button(onClick = { navController.navigate(Screen.Third.createRoute("So easy",100)) }) {
                Text(text = "Go Third Screen")
            }
        }
    }
}