package com.rock.composenavigationdemo.screen

import android.util.Log
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

private const val TAG = "FourthScreen"
@Composable
fun FourthScreen(navController: NavController){
    //打印 back stack
    Log.e(TAG, "back stack : ${navController.backQueue
        //navController 第一个 NavBackStackEntry 是 NavGraph , 它的 route 是 null
        .filter { it.destination.route  != null }
        .map { it.destination.route }}"
    )
    Scaffold {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Fourth")
        }
    }
}