package com.filleuxstudio.myapplicationkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.filleuxstudio.myapplicationkotlin.navigation.HomeNavHost
import com.filleuxstudio.myapplicationkotlin.ui.theme.MyApplicationKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        setContent {
            MyApplicationKotlinTheme {
                val navController = rememberNavController()
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp)
                            .background(Color(0xff004585))
                    ) {
                        HomeNavHost(
                            navController = navController
                        ) // Will be red for the beginning
                    }
                }
            }
        }
    }

@Preview(showBackground = true)@Composable
fun GreetingPreview() {
    MyApplicationKotlinTheme {
    }
}
