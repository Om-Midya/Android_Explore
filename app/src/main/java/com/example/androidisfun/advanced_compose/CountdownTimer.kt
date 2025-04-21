package com.example.androidisfun.advanced_compose

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun CountdownTimer(time: Int = 30) {
    val timeLeft = remember {
        mutableIntStateOf(time)
    }
     val context = LocalContext.current

    LaunchedEffect(key1 = timeLeft){
        while(timeLeft.intValue > 0){
            delay(1000L)
            timeLeft.intValue--
        }
        Toast.makeText(
            context,
            "Time's up!",
            Toast.LENGTH_SHORT
        ).show()
    }
    Text(
        text = "${timeLeft.intValue}",
        style = androidx.compose.material3.MaterialTheme.typography.headlineLarge
    )
}

@Preview
@Composable
private fun ShowCountdownTimer() {
    CountdownTimer()
}