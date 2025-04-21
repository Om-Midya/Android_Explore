package com.example.androidisfun.canvas

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DynamicSlider() {
    val progress = remember {
        mutableFloatStateOf(0.5f)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                //Background Circle
                drawArc(
                    color = Color.LightGray,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = 16f)
                )

                drawArc(
                    color = Color(0xFF4285F4),
                    startAngle = -90f,
                    sweepAngle = 360f * progress.floatValue,
                    useCenter = false,
                    style = Stroke(width = 16f, cap = StrokeCap.Round)
                )
            }
            Text(
                text = "${(progress.floatValue*100).toInt()}%",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black,
                fontSize = 70.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Slider(
            value = progress.floatValue,
            onValueChange = { progress.floatValue = it },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

    }
}

@Composable
fun DynamicSliderPaint() {
    val progress = remember {
        mutableFloatStateOf(0.5f)
    }

    val textPaint = remember {
        Paint().apply {
            color = Color.Black.toArgb()
            textAlign = Paint.Align.CENTER
            textSize = 100f
            isAntiAlias = true
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Canvas(modifier = Modifier.size(200.dp)) {
                //Background Circle
                drawArc(
                    color = Color.LightGray,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = 16f)
                )

                drawArc(
                    color = Color(0xFF4285F4),
                    startAngle = -90f,
                    sweepAngle = 360f * progress.floatValue,
                    useCenter = false,
                    style = Stroke(width = 16f, cap = StrokeCap.Round)
                )

            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    "${(progress.floatValue * 100).toInt()}%",
                    center.x,
                    center.y + textPaint.textSize / 2,
                    textPaint
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Slider(
            value = progress.floatValue,
            onValueChange = { progress.floatValue = it },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

    }
}

@Preview
@Composable
private fun ShowDynamicSlider() {
    DynamicSliderPaint()
}