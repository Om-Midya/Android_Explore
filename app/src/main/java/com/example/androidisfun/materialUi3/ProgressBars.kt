package com.example.androidisfun.materialUi3

import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun DeterminateProgressBars() {
    val currentProgress = remember { mutableFloatStateOf(0f) }
    val isLoading = remember { mutableStateOf(false) }
    val currentScope = rememberCoroutineScope()

    //Little Animation
    val animatedProgress = animateFloatAsState(
        targetValue = currentProgress.floatValue,
        animationSpec = tween(200, easing = LinearEasing)
    )

    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            isLoading.value = true
            currentScope.launch {
                loadProgress{
                    currentProgress.floatValue = it
                }
                Toast.makeText(
                    context,
                    "Loading Complete",
                    Toast.LENGTH_SHORT
                ).show()
                delay(500)
                isLoading.value = false
                currentProgress.floatValue = 0f
            }
        },
            enabled = !isLoading.value
        ) {
            Text("Start Loading")
        }

        Text(text = "Progress: ${(currentProgress.floatValue * 100).roundToInt()}%")

        if(isLoading.value) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(100.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.fillMaxSize(),
                    progress = { animatedProgress.value },
                    strokeWidth = 8.dp,
                    trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
                )

                Text(
                    text = "${(animatedProgress.value * 100).toInt()}%",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

suspend fun loadProgress(updateProgress: (Float) -> Unit){
    for (i in 0..100){
        updateProgress(i.toFloat()/100)
        delay(100)
    }
}

@Preview
@Composable
private fun ShowProgressBars() {
    DeterminateProgressBars()
}