package com.rock.composenavigationdemo.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

private const val TAG = "SecondScreen"
@Composable
fun SecondScreen(navController: NavController){
    //打印 back stack
    Log.e(TAG, "back stack : ${navController.backQueue
        //navController 第一个 NavBackStackEntry 是 NavGraph , 它的 route 是 null
        .filter { it.destination.route  != null }  
        .map { it.destination.route }}"
    )
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
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                //SecondScreen 中 navigate 到 SecondScreen ，会创建一个新的 SecondScreen 放到 back 栈顶
                //back 栈就会多个 SecondScreen 实例

                navController.navigate(Screen.Second.route){
                    //如果 back 栈顶的实例跟 navigate 方法指定的路由一样，不重新创建实例，只触发 recompose
                    launchSingleTop = true
                }
            }) {
                Text(text = "Launch Self")
            }
        }
    }
}