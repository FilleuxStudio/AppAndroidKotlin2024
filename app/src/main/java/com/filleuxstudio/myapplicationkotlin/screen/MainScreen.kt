package com.filleuxstudio.myapplicationkotlin.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.filleuxstudio.myapplicationkotlin.R


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
                 color = Color.White,
                 modifier = Modifier.padding(bottom=20.dp)
            )
            Button(
                shape = RoundedCornerShape(20.dp),// Border radius
                content = {
                    Text(text = "Ma liste",
                        fontWeight = FontWeight.Bold,)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffc52b30), // Button background color
                    contentColor = Color.White   // Font color
                ),
                onClick = { onButtonClick() }

            )
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.logo_bmw),
                contentDescription = "logo group bmw",
                modifier = Modifier.size(100.dp)
            )
        }
   }