package com.example.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.onboarding.R
import com.example.onboarding.domain.Screenall
import com.example.onboarding.ui.theme.*

@Composable
fun OnboardingScreen1(navController: NavHostController) {
    val data = createScreenData(
        backgroundColor = BackgroundYellow,
        nextScreen = "screen2",
        firstTitle = "Your first car without \n" + "a driver's license",
        isTitleBold = false,
        secondTitle = "Goes to meet people who just got their license",
        picId = R.drawable.human1,
        dotsId = R.drawable.switching1,
        arrowId = R.drawable.button1
    )
    OnboardingScreen(data, navController)
}

@Composable
fun OnboardingScreen2(navController: NavHostController) {
    val data = createScreenData(
        backgroundColor = BackgroundPurple,
        nextScreen = "screen3",
        firstTitle = "Always there: more than \n" + "1000 cars in Tbilisi",
        isTitleBold = true,
        secondTitle = "Our company is a leader by the \n" + "number of cars in the fleet",
        picId = R.drawable.human2,
        dotsId = R.drawable.switching2,
        arrowId = R.drawable.button2
    )
    OnboardingScreen(data, navController)
}

@Composable
fun OnboardingScreen3(navController: NavHostController) {
    val data = createScreenData(
        backgroundColor = BackgroundRed,
        nextScreen = "screen4",
        firstTitle = "Do not pay for parking, \n" + "maintenance and gasoline",
        isTitleBold = true,
        secondTitle = "We will pay for you, all expenses \n" + "related to the car",
        picId = R.drawable.human3,
        dotsId = R.drawable.switching3,
        arrowId = R.drawable.button3
    )
    OnboardingScreen(data, navController)
}

@Composable
fun OnboardingScreen4(navController: NavHostController) {
    val data = createScreenData(
        backgroundColor = BackgroundBlue,
        nextScreen = "screen5",
        firstTitle = "29 car models: from Skoda \n" + "Octavia to Porsche 911",
        isTitleBold = true,
        secondTitle = "Choose between regular car models \n" + "or exclusive ones",
        picId = R.drawable.human4,
        dotsId = R.drawable.switching4,
        arrowId = R.drawable.button4
    )
    OnboardingScreen(data, navController)
}

@Composable
fun OnboardingScreen5() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundBlue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "You are a clever person!",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun createScreenData(
    backgroundColor: Color,
    nextScreen: String,
    firstTitle: String,
    isTitleBold: Boolean,
    secondTitle: String,
    picId: Int,
    dotsId: Int,
    arrowId: Int
): Screenall {
    return Screenall(
        backgroundColor = backgroundColor,
        nextScreen = nextScreen,
        firstTitle = firstTitle,
        isTitleBold = isTitleBold,
        secondTitle = secondTitle,
        picId = picId,
        dotsId = dotsId,
        arrowId = arrowId
    )
}
