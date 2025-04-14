package com.example.androidisfun.canvas

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

@Composable
fun FacebookIcon() {
//    val assetManager = LocalContext.current.assets
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
//        typeface = Typeface.createFromAsset(assetManager, "FACEBOLF.OTF")
    }
    Canvas(
        modifier = Modifier
            .size(100.dp) // Set the size of the canvas
            .border(1.dp, Color.Black) // Optional: Add a border to the canvas
            .padding(16.dp) // Add padding around the canvas
    ){
        drawRoundRect(
            color = Color(0xFF3b5998), // Facebook blue color
            size = this.size,
            cornerRadius = CornerRadius(20f, 20f) // Set the corner radius for rounded corners
        )
        drawContext.canvas.nativeCanvas.drawText("f", center.x + 20, center.y + 90, paint)
    }

}