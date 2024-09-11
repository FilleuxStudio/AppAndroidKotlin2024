package com.filleuxstudio.myapplicationkotlin.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.filleuxstudio.myapplicationkotlin.data.model.OpenF1DriverObject
import com.filleuxstudio.myapplicationkotlin.model.ItemUI
import com.filleuxstudio.myapplicationkotlin.viewmodel.OpenF1DriverViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenF1Screen(
    navController: NavController,
) {
    val viewModel: OpenF1DriverViewModel = viewModel()
    val list = viewModel.openf1.collectAsState(emptyList()).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Liste des pilotes de F1") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            Row(
                Modifier.padding(start = 8.dp, end= 8.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    content = {
                        Text("Add")
                    },
                    onClick = {
                        viewModel.insertAllDriver()
                    } ,
                    shape = RoundedCornerShape(5.dp),// Border radius,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff00b159), // Button background color
                        contentColor = Color.White   // Font color
                    ),
                )
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    modifier = Modifier.weight(1f),
                    content = {
                        Text("Delete")
                    },
                    onClick = {
                        viewModel.deleteAllDriver()
                    },
                    shape = RoundedCornerShape(5.dp),// Border radius
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffd11141), // Button background color
                        contentColor = Color.White   // Font color
                    ),
                )
            }
        }


    ) { padding ->
        ScreenOpenF1(
            Modifier.padding(padding), list
        )
    }
}

@Composable
private fun ScreenOpenF1(modifier: Modifier, listOfResult:List<OpenF1DriverObject>) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {

        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(listOfResult) { item ->

                OutlinedCard(
                    modifier = Modifier.fillParentMaxWidth().padding(bottom=10.dp),
                    shape = RoundedCornerShape(5.dp),
                    border = BorderStroke(2.dp, Color(android.graphics.Color.parseColor("#${item.teamcolour}"))),
                ) {
                    Column(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = item.teamName,
                            fontSize = 24.sp,
                            color = Color(0xffdc0000)
                        )
                        Text(
                            text = item.fullName,
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                        val painter = rememberAsyncImagePainter(
                            ImageRequest
                                .Builder(LocalContext.current)
                                .data(data = item.headshotUrl)
                                .build(),
                        )
                        Image(
                            modifier = Modifier
                                .size(128.dp),
                            painter = painter,
                            contentDescription = null,
                        )

                    }
                }
            }
        }
    }
}
