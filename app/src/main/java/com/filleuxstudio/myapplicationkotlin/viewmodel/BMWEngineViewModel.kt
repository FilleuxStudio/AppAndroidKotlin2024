package com.filleuxstudio.myapplicationkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filleuxstudio.myapplicationkotlin.data.BMWViewModel
import com.filleuxstudio.myapplicationkotlin.model.BMWEngine
import com.filleuxstudio.myapplicationkotlin.model.ItemUI
import com.filleuxstudio.myapplicationkotlin.model.bmwEngines
import com.filleuxstudio.myapplicationkotlin.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BMWEngineViewModel: ViewModel() {
    private val _BmwEngineList = MutableStateFlow<List<ItemUI>>(emptyList())
    private val BmwEngineRepository: BMWViewModel by lazy{BMWViewModel()}
    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val BmwEngineList: StateFlow<List<ItemUI>> get() = _BmwEngineList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // On exécute dans un petit thread dédié à Input/Output le fait de générer la liste
            _BmwEngineList.emit(populateMyListTest())
        }

    }

    /*private fun populateMyList(): List<ItemUI> {
        val result = mutableListOf<ItemUI>()
        listOf(
            ItemUI.MyAndroidObject( 3.0,"B58",  382),     // BMW B58 (3.0L, 382ch)
            ItemUI.MyAndroidObject(3.0, "S58", 503),     // BMW S58 (3.0L, 503ch)
            ItemUI.MyAndroidObject(3.0, "N55", 300),     // BMW N55 (3.0L, 300ch)
            ItemUI.MyAndroidObject(3.0, "N54", 335),     // BMW N54 (3.0L, 335ch)
            ItemUI.MyAndroidObject( 3.0,"M54",  231),     // BMW M54 (3.0L, 231ch)
            ItemUI.MyAndroidObject(4.9, "S62", 400),     // BMW S62 (4.9L, 400ch)
            ItemUI.MyAndroidObject( 3.2,"S50B32",  321),  // BMW S50B32 (3.2L, 321ch)
            ItemUI.MyAndroidObject( 2.5, "M20B25", 171),  // BMW M20B25 (2.5L, 171ch)
            ItemUI.MyAndroidObject( 3.4, "M30B34", 218),  // BMW M30B34 (3.4L, 218ch)
            ItemUI.MyAndroidObject(1.8, "M10B18",  110)   // BMW M10B18 (1.8L, 110ch)
        ).groupBy { myAndroidObject ->
            myAndroidObject.displacement
        } // map <String, List<MyAndroidObject>>
            .forEach {
                result.add(
                    ItemUI.Header(
                        year = it.key.toInt(),// versionName
                    )
                )
                result.addAll(it.value) // List of android version number for the given name
            }
        return result
    }*/

    private fun populateMyListTest(): List<ItemUI> {
        val result = mutableListOf<ItemUI>()

        BmwEngineRepository.populateMyList().groupBy { myAndroidObject ->
            myAndroidObject.displacement
        } // map <String, List<MyAndroidObject>>
            .forEach {
                result.add(
                    ItemUI.Header(
                        year = it.key.toInt(),// année
                    )
                )

               /* result.addAll(it.value.map { engineType ->
                    ItemUI.Item(
                        displacement = engineType.displacement,
                        engineCode = engineType.engineCode,
                        horsepower = engineType.horsepower
                    )
                })*/
                result.addAll(it.value.toUi())

                result.add(
                    ItemUI.Footer(
                        pub = "https://www.autocollant-tuning.com/1375/bmw-couleur.jpg"
                    )
                )
            }
        return result
    }
}
