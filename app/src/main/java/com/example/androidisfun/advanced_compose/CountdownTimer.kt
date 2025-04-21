package com.example.androidisfun.advanced_compose

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CountdownTimer() {
    val coroutineScope = rememberCoroutineScope()

    val inputTime = remember { mutableStateOf("") }
    val timeLeft = remember { mutableIntStateOf(0) }
    val isRunning = remember { mutableStateOf(false) }
    val isPaused = remember { mutableStateOf(false) }
    val countDownJob = remember { mutableStateOf<Job?>(null) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Time input
        OutlinedTextField(
            value = inputTime.value,
            onValueChange = { inputTime.value = it.filter { char -> char.isDigit() } },
            label = { Text("Enter seconds") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth(0.7f),
            enabled = !isRunning.value
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Countdown text
        Text(
            text = timeLeft.intValue.toString(),
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            //start button
            Button(onClick = {
                val totalSeconds = inputTime.value.toLongOrNull() ?: return@Button
                if(!isRunning.value && !isPaused.value){
                    //start fresh countdown
                    timeLeft.intValue = totalSeconds.toInt()
                }else if(isPaused.value){
                    isPaused.value = false
                }
                isRunning.value = true

                if(countDownJob.value == null || countDownJob.value?.isActive == false){
                    countDownJob.value = coroutineScope.launch {
                        while(timeLeft.intValue > 0 && isRunning.value){
                            delay(1000L)
                            if(!isPaused.value){
                                timeLeft.intValue -= 1
                            }
                        }

                        if (timeLeft.intValue == 0) {
                            isRunning.value = false
                            Toast.makeText(
                                context,
                                "Countdown finished!",
                                Toast.LENGTH_SHORT
                            ).show()
                            countDownJob.value = null
                        }
                    }
                }
            },
                enabled = inputTime.value.isNotEmpty() && (!isRunning.value || isPaused.value)
            ) {
                Text(if (isPaused.value) "Resume" else "Start")
            }

            //pause button
            Button(onClick = {
                isPaused.value = true
            },
                enabled = isRunning.value && !isPaused.value
            ) {
                Text("Pause")
            }

            //cancel button
            Button(onClick = {
                isRunning.value = false
                isPaused.value = false
                countDownJob.value?.cancel()
                countDownJob.value = null
                timeLeft.intValue = 0
                inputTime.value = ""
            }) {
                Text("Cancel")
            }
        }
    }
}

@Preview
@Composable
private fun ShowCountdownTimer() {
    CountdownTimer()
}