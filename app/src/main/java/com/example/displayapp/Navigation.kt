package com.example.displayapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.displayapp.com.example.displayapp.MainViewModel

@Composable
fun Nav(){
    val View_Model : MainViewModel = viewModel()
    val viewState by View_Model.postState
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.DisplayScreen, builder =  {
        composable(route = Routes.DisplayScreen){
            DisplayScreen(navController)
        }
        composable(route = Routes.UserScreen){
            UserScreen(navController)
        }
    }
    )
}