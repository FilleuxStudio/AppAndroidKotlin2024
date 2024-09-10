package com.filleuxstudio.myapplicationkotlin.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme/**/
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.filleuxstudio.myapplicationkotlin.model.BMWEngine
import com.filleuxstudio.myapplicationkotlin.model.ItemUI
import com.filleuxstudio.myapplicationkotlin.model.bmwEngines

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Liste des moteurs BMW") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        MyScreen(
            Modifier.padding(padding)
        )
    }
}


private fun populateMyList(): List<ItemUI.MyAndroidObject> {
    return bmwEngines.map { engineType ->
        ItemUI.MyAndroidObject(
            displacement = engineType.displacement,
            engineCode = engineType.engineCode,
            horsepower = engineType.horsepower
        )
    }
}

@Composable
fun Picture(url:String, modifier: Modifier){

    Box (
        modifier = modifier.fillMaxWidth()
    ) {
        val painter = rememberAsyncImagePainter(
            ImageRequest
                .Builder(LocalContext.current)
                .data(data = url)
                .build(),
        )
        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(128.dp),
            painter = painter,
            contentDescription = null,
        )
    }
}

@Composable
private fun MyScreen(modifier: Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        val listOfResult: MutableList<ItemUI> = mutableListOf()
        populateMyList() // listOf(MyAndroidObject)
            .groupBy { myAndroidObject ->
                myAndroidObject.displacement
            } // map <String, List<MyAndroidObject>> ex : <Ice Cream Sandwich, listOf("4.0.0","4.0.1","4.0.2","4.0.3")>
            .forEach { // versionName
                listOfResult.add(
                    ItemUI.Header(
                        year = it.key.toInt(),
                    )
                )
                listOfResult.addAll(
                    it.value // List of android version number for the given name
                )
                listOfResult.add(
                    ItemUI.Footer(
                        pub = "https://www.autocollant-tuning.com/1375/bmw-couleur.jpg"
                    )
                )
            }

        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(listOfResult) { item ->
                when (item) {
                    is ItemUI.Header -> OutlinedCard(
                        modifier = Modifier.fillParentMaxWidth(),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = item.year.toString(),
                                style = MaterialTheme.typography.displayMedium,
                                color = Color(0xff33a0d1)
                            )

                        }
                    }

                    is ItemUI.MyAndroidObject -> {
                        Text(
                            text = "Code Moteur : ${item.engineCode}"
                        )
                        Text(
                            text = "CH : ${item.horsepower}"
                        )
                        Text(
                            text = "Cylindrée : ${item.displacement}"
                        )
                    }

                    is ItemUI.Footer -> {
                        val painter = rememberAsyncImagePainter(
                            ImageRequest
                                .Builder(LocalContext.current)
                                .data(data = item.pub)
                                .build(),
                        )
                        Image(
                            modifier = Modifier.size(74.dp).padding(8.dp),
                            painter = painter,
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}