package com.rock.composenavigationdemo.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.First.route){

        composable(Screen.First.route){
            FirstScreen(navController)
        }

        composable(Screen.Second.route){
            SecondScreen(navController)
        }

        composable(route = Screen.Third.route, arguments = Screen.Third.arguments) {
            val arg1 = Screen.Third.getArg1(it)
            val arg2 = Screen.Third.getArg2(it)
            ThirdScreen(navController,arg1,arg2)
        }
    }
}