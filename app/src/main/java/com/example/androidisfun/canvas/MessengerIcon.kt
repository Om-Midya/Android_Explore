package com.example.androidisfun.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun MessengerIcon() {
    val colors = listOf(Color(0xFF02b8f9),  Color(0xFF0277fe))

    Canvas(
        modifier = Modifier
            .size(100.dp) // Set the size of the canvas
            .border(1.dp, Color.Black) // Optional: Add a border to the canvas
            .padding(16.dp) // Add padding around the canvas
    ) {
        val trianglePath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * .77f)
            it.lineTo(this.size.width * .20f, this.size.height * 0.95f)
            it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
            it.close()
            it
        }

        val electricPath = Path().let{
            it.moveTo(this.size.width * .20f, this.size.height * 0.60f)
            it.lineTo(this.size.width * .45f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.56f, this.size.height * 0.46f)
            it.lineTo(this.size.width * 0.78f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.54f, this.size.height * 0.60f)
            it.lineTo(this.size.width * 0.43f, this.size.height * 0.45f)
            it.close()
            it
        }
        drawOval(
            brush = Brush.verticalGradient(colors = colors),
            size = Size(this.size.width, this.size.height* .95f)
        )

        drawPath(
            path = trianglePath,
            brush = Brush.verticalGradient(colors = colors),
            style = Stroke(width = 15f)
        )

        drawPath(
            path = electricPath,
            color = Color.White
        )
    }
}