package com.rock.composenavigationdemo.screen

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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

        composable(route = Screen.Third.route, arguments = Screen.Third.arguments,
            deepLinks = listOf(
                navDeepLink { uriPattern = "test://nav.test.thirdscreen/{arg1}?arg2={arg2}"  }
            )
        ) {
            val arg1 = Screen.Third.getArg1(it)
            val arg2 = Screen.Third.getArg2(it)
            ThirdScreen(navController,arg1,arg2)
        }
    }
}