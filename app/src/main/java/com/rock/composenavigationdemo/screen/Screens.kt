package com.rock.composenavigationdemo.screen

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable


open class Screen(val route:String){
    open val arguments:List<NamedNavArgument> = emptyList()
    open val deepLinks:List<NavDeepLink> = emptyList()

    object First:Screen("first")
    object Second:Screen("second")

    object Third:Screen("third/{arg1}?arg2={arg2}"){
        //override arguments 指定参数类型
        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument("arg1"){type = NavType.StringType},
                navArgument(name = "arg2"){ defaultValue = 0 },
            )
        override val deepLinks: List<NavDeepLink>
            get() = listOf(
                navDeepLink { uriPattern = "test://nav.test.thirdscreen/{arg1}?arg2={arg2}"  }
            )
        //参数获取
        fun getArg1(backStackEntry: NavBackStackEntry):String = backStackEntry.arguments?.getString("arg1")!!
        fun getArg2(backStackEntry: NavBackStackEntry):Int = backStackEntry.arguments?.getInt("arg2")!!
        //根据参数创建 navigate() 时使用的路由
        fun createRoute(arg1:String,arg2:Int = 0):String = "third/$arg1?arg2=$arg2"
    }
    object Fourth:Screen("fourth")
}

fun NavGraphBuilder.composableScreen(screen: Screen, content: @Composable (NavBackStackEntry) -> Unit){
    composable(route = screen.route,
        arguments = screen.arguments,
        deepLinks = screen.deepLinks,
        content = content)
}





