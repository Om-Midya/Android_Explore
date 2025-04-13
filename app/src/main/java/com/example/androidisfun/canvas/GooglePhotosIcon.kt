package com.example.androidisfun.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GooglePhotosIcon(modifier: Modifier = Modifier) {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .border(1.dp, Color.Black)// Set the size of the canvas
            .padding(16.dp) // Add padding around the canvas
    ) {
        drawArc(
            color = Color(0xFFf04231),
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, 0f)
        )
        drawArc(
            color = Color(0xFF4385f7),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .50f, size.height * .25f)
        )
        drawArc(
            color = Color(0xFF30a952),
            startAngle = 90f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, size.height * .50f)
        )
        drawArc(
            color = Color(0xFFffbf00),
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(0f, size.height * .25f)
        )
    }
}

@Preview
@Composable
private fun PreviewIcons() {
    GooglePhotosIcon()
}