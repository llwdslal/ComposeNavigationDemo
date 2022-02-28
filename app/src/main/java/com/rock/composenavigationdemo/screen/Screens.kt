package com.rock.composenavigationdemo.screen

sealed class Screen(val route:String,val name:String){
    object Home:Screen("home","Home")
    object SecondScreen:Screen("second","Second")
}