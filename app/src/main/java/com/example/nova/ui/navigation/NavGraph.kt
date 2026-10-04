package com.example.nova.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nova.ui.home.HomeScreen
import com.example.nova.ui.listening.ListeningScreen
import com.example.nova.ui.result.ResultScreen

@Composable
fun NovaNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onSpeakClick = { navController.navigate("listening") },
                onSeeClick = { navController.navigate("camera") }
            )
        }
        composable("listening") {
            ListeningScreen(
                onCancel = { navController.popBackStack() },
                onResult = { result -> navController.navigate("result/$result") }
            )
        }
        composable("camera") {
             com.example.nova.ui.camera.CameraScreen(
                 onCapture = { text -> 
                     navController.navigate("context/${android.net.Uri.encode(text)}") 
                 },
                 onCancel = { navController.popBackStack() }
             )
        }
        composable("context/{ocrText}") { backStackEntry ->
            val ocrText = backStackEntry.arguments?.getString("ocrText") ?: ""
            com.example.nova.ui.context.ContextScreen(
                ocrText = ocrText,
                onHandleThis = {
                    navController.navigate("action_plan/${android.net.Uri.encode(ocrText)}")
                },
                onCancel = { navController.popBackStack("home", false) }
            )
        }
        composable("action_plan/{ocrText}") { backStackEntry ->
             val ocrText = backStackEntry.arguments?.getString("ocrText") ?: ""
             com.example.nova.ui.context.ActionPlanScreen(
                 ocrText = ocrText,
                 onConfirmAction = { action ->
                     navController.navigate("result/Executed action: $action")
                 },
                 onCancel = { navController.popBackStack("home", false) }
             )
        }
        composable("result/{message}") { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message") ?: ""
            ResultScreen(message = message, onHome = {
                navController.popBackStack("home", false)
            })
        }
    }
}
