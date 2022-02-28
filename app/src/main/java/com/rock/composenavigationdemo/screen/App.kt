package com.rock.composenavigationdemo.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App(){
    val navController = rememberNavController()

    Scaffold {
        NavHost(navController = navController, startDestination = Screen.Home.route){
            composable(Screen.Home.route){
                Home(navController)
            }

            composable(Screen.SecondScreen.route){
                SecondScreen(navController)
            }
        }
    }
}