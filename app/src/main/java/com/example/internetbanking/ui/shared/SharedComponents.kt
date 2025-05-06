package com.example.internetbanking.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internetbanking.ui.theme.GradientColors

// Gradient Background
@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .background(
                brush = GradientColors.GreenDarkToLight
            )
    ) {
        content()
    }
}

@Composable
fun GreenGradientButton(
    onButtonClick: () -> Unit,
    buttonText: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Transparent
        ),
        modifier = modifier
            .background(
                shape = RoundedCornerShape(12.dp),
                brush = GradientColors.GreenDarkToLight
            )
    ) {
        Text(
            text = buttonText,
            fontSize = 20.sp
        )
    }
}

