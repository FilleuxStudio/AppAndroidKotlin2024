package com.filleuxstudio.myapplicationkotlin.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


@Composable
   fun MainScreen(
        onButtonClick: () -> Unit,
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, // Centers horizontally
            verticalArrangement = Arrangement.Center // Centers vertically

        ){
            Text(
                text = "FILLEUX Dimitri",
                fontWeight = FontWeight.Bold,
                 color = Color.White)
            Button(
                //modifier = Modifier.background(Color(0xfffb2e01)),
                content = {
                    Text("Ma liste")
                },
                onClick = { onButtonClick() }

            )
        }
   }