package com.example.displayapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Screen_1") {
        composable(route = "Screen_1"){
            DisplayScreen(navController)
        }
        composable(route = "Screen_2"){
            UserScreen(navController)
        }
    }
}