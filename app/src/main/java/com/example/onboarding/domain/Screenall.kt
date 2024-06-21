package com.example.onboarding.domain

import androidx.compose.ui.graphics.Color

data class Screenall (
    val backgroundColor: Color,
    val nextScreen: String,
    val firstTitle: String,
    val isTitleBold: Boolean,
    val secondTitle: String,
    val picId: Int,
    val dotsId: Int,
    val arrowId: Int
)