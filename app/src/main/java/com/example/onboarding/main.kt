package com.example.onboarding

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboarding.presentation.OnboardingScreen1
import com.example.onboarding.presentation.OnboardingScreen2
import com.example.onboarding.presentation.OnboardingScreen3
import com.example.onboarding.presentation.OnboardingScreen4
import com.example.onboarding.presentation.OnboardingScreen5

@Composable
fun OnboardingNav(navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = OnboardingScreens.Screen1.route) {
        OnboardingScreens.values().forEach { screen ->
            composable(
                route = screen.route,
                enterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(durationMillis = 1000)
                    )
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { -it },
                        animationSpec = tween(durationMillis = 1000)
                    )
                }
            ) {
                screen.Content(navController)
            }
        }
    }
}

enum class OnboardingScreens(val route: String, val Content: @Composable (NavHostController) -> Unit) {
    Screen1("screen1", { navController -> OnboardingScreen1(navController) }),
    Screen2("screen2", { navController -> OnboardingScreen2(navController) }),
    Screen3("screen3", { navController -> OnboardingScreen3(navController) }),
    Screen4("screen4", { navController -> OnboardingScreen4(navController) }),
    Screen5("screen5", { _ -> OnboardingScreen5() })
}
