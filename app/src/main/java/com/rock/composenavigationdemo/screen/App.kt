package com.rock.composenavigationdemo.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route){

        composable(Screen.Home.route){
            FirstScreen(navController)
        }

        composable(Screen.SecondScreen.route){
            SecondScreen(navController)
        }
    }
}