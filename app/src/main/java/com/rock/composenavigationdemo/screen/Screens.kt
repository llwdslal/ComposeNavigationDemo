package com.rock.composenavigationdemo.screen

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route:String){
    open val arguments:List<NamedNavArgument> = emptyList()

    object First:Screen("first")
    object Second:Screen("second")

    object Third:Screen("third/{arg1}?arg2={arg2}"){
        //override arguments 指定参数类型
        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument("arg1"){type = NavType.StringType},
                navArgument(name = "arg2"){ defaultValue = 0 },
            )
        //参数获取
        fun getArg1(backStackEntry: NavBackStackEntry):String = backStackEntry.arguments?.getString("arg1")!!
        fun getArg2(backStackEntry: NavBackStackEntry):Int = backStackEntry.arguments?.getInt("arg2")!!
        //根据参数创建 navigate() 时使用的路由
        fun createRoute(arg1:String,arg2:Int = 0):String = "third/$arg1?arg2=$arg2"
    }
}

