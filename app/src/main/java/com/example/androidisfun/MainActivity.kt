package com.example.androidisfun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidisfun.canvas.FacebookIcon
import com.example.androidisfun.canvas.GooglePhotosIcon
import com.example.androidisfun.canvas.InstagramIcon
import com.example.androidisfun.canvas.IosWeatherAppIcon
import com.example.androidisfun.canvas.MessengerIcon
import com.example.androidisfun.ui.theme.AndroidIsFunTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            AndroidIsFunTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        item {
                            InstagramIcon()
                        }
                        item{
                            FacebookIcon()
                        }
                        item {
                            MessengerIcon()
                        }
                        item{
                            GooglePhotosIcon()
                        }
                        item{
                            IosWeatherAppIcon()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidIsFunTheme {
        Greeting("Android")
    }
}