package com.example.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.onboarding.domain.Screenall

@Composable
fun OnboardingScreen(data: Screenall, navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = data.backgroundColor
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            OnboardingHeader(
                firstTitle = data.firstTitle,
                secondTitle = data.secondTitle,
                isTitleBold = data.isTitleBold
            )
            OnboardingImage(
                picId = data.picId,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
            )
            OnboardingFooter(
                dotsId = data.dotsId,
                arrowId = data.arrowId,
                onSkipClick = { navController.navigate("screen5") },
                onNextClick = { navController.navigate(data.nextScreen) }
            )
        }
    }
}

@Composable
fun OnboardingHeader(firstTitle: String, secondTitle: String, isTitleBold: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp, bottom = 24.dp)
    ) {
        Text(
            color = Color.White,
            fontSize = 28.sp,
            text = firstTitle,
            fontWeight = if (isTitleBold) FontWeight.Bold else FontWeight(300),
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Text(
            color = Color.White,
            fontSize = 18.sp,
            text = secondTitle
        )
    }
}

@Composable
fun OnboardingImage(picId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(picId),
        contentDescription = "Onboarding image",
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )
}

@Composable
fun OnboardingFooter(dotsId: Int, arrowId: Int, onSkipClick: () -> Unit, onNextClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 23.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 24.dp, top = 6.dp)
                .weight(1f)
        ) {
            Image(
                painter = painterResource(dotsId),
                contentDescription = "Dots indicator",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(72.dp)
                    .height(8.dp)
            )
            Text(
                "Skip",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight(250),
                modifier = Modifier
                    .clickable { onSkipClick() }
                    .padding(top = 15.dp)
            )
        }
        IconButton(
            onClick = onNextClick,
            modifier = Modifier
                .size(58.dp)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(arrowId),
                contentDescription = "Arrow icon",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
