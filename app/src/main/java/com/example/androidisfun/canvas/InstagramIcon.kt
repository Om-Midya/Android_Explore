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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun InstagramIcon() {
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp) // Set the size of the canvas
            .border(1.dp, Color.Black) // Optional: Add a border to the canvas
            .padding(16.dp) // Add padding around the canvas
    ) {
        drawRoundRect(
            brush = Brush.linearGradient(colors = instaColors),
            cornerRadius = CornerRadius(50f, 50f),
            style = Stroke(width = 10f) // Set the stroke width
        )

        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = this.size.width* .25f, // Set the radius of the circle (30f) means 30 pixels
            style = Stroke(width = 12f) // Set the stroke width and cap style
        )

        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 10f,
            center = Offset(x = this.size.width* .80f, y =  this.size.width* .20f), // Set the center of the circle
        )
    }
}