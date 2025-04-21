package com.example.androidisfun.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ZigZag(repeats: Int = 10) {
    Canvas(modifier = Modifier
        .size(100.dp)
        .border(1.dp, Color.Black) // Optional: Add a border to the canvas
        .padding(4.dp) // Add padding around the canvas
    ) {
        val step: Float = size.width / (repeats*2)

        val path = Path().apply {
            moveTo(0f, size.height/2)
            for(i in 0 until repeats){
                val x1 = step * (i*2 + 1)
                val y1 = size.height * (if(i % 2 == 0) .25f else .75f)

                lineTo(x1, y1)
            }
            lineTo(size.width, size.height/2)
            close()
        }

        drawPath(path = path, color = Color.Yellow)
    }
}

@Preview
@Composable
private fun ZigZagPreview() {
    ZigZag()
}