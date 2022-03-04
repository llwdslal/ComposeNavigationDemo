package com.rock.composenavigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rock.composenavigationdemo.screen.FirstScreen
import com.rock.composenavigationdemo.screen.Screen
import com.rock.composenavigationdemo.screen.SecondScreen
import com.rock.composenavigationdemo.ui.theme.ComposeNavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()// 创建 NavController
                    //创建 NavController ， 使用 NavGraphBuilder 设置 NavGraph , 指定第一个启动的路由名称
                    NavHost(navController = navController, startDestination = "FirstScreen"){
                        //声明路由 ，指定路由名称 和 路由 对应的 Compose UI
                        composable("FirstScreen"){
                            //将 NavController 传递给 FirstScreen，在 FirstScreen 中控制路由
                            FirstScreen(navController)
                        }
                        composable("SecondScreen"){
                            SecondScreen(navController)
                        }
                    }
                }
            }
        }
    }
}