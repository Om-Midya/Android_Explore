package com.example.androidisfun.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun IosWeatherAppIcon() {
    val backgroundColor = listOf(Color(0xFF2078EE), Color(0xFF74E6FE))
    val sunColor = listOf(Color(0xFFFFC200), Color(0xFFFFE100))

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .border(1.dp, Color.Black) // Optional: Add a border to the canvas
            .padding(16.dp) // Add padding around the canvas
    ) {
        val width = size.width
        val height = size.height

        val cloudPath = Path().apply{
            moveTo(width.times(.76f), height.times(.72f))
            cubicTo(
                width.times(.93f),
                height.times(.72f),
                width.times(.98f),
                height.times(.41f),
                width.times(.76f),
                height.times(.40f)
            )
            cubicTo(
                width.times(.75f),
                height.times(.21f),
                width.times(.35f),
                height.times(.21f),
                width.times(.38f),
                height.times(.50f)
            )
            cubicTo(
                width.times(.25f),
                height.times(.50f),
                width.times(.20f),
                height.times(.69f),
                width.times(.41f),
                height.times(.72f)
            )
            close()
        }

        // Draw the background
        drawRoundRect(
            brush = Brush.verticalGradient(backgroundColor),
            cornerRadius = CornerRadius(40f, 40f)
        )
        // Draw the sun
        drawCircle(
            brush = Brush.verticalGradient(sunColor),
            radius = width * .17f,
            center = Offset(width * .35f, height * .35f)
        )

        drawPath(
            path = cloudPath,
            color = Color.White.copy(alpha = .85f)
        )
    }
}