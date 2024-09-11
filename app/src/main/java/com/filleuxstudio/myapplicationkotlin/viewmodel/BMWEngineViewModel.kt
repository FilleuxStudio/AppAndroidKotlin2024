package com.filleuxstudio.myapplicationkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filleuxstudio.myapplicationkotlin.data.BMWEngineResp
import com.filleuxstudio.myapplicationkotlin.model.ItemUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class BMWEngineViewModel: ViewModel() {
    private val BmwEngineRepository: BMWEngineResp by lazy{BMWEngineResp()}
    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val BMWEnginelist: Flow<List<ItemUI>> get() = _BmwEngineList


    private val _BmwEngineList: Flow<List<ItemUI>>
        get() = BmwEngineRepository.selectAllBmwEngine().map { BMWEngineObjectEntity ->
            BMWEngineObjectEntity.groupBy { BMWEngineObjectEntity ->
                BMWEngineObjectEntity.displacement
                BMWEngineObjectEntity.engineCode
                BMWEngineObjectEntity.horsepower
                BMWEngineObjectEntity.year
            } .flatMap {
                buildList {
                    add(ItemUI.Header(
                        year = it.key,
                    ))
                    addAll(it.value)
                    add(ItemUI.Footer(
                        pub = "https://www.c3signage.co.uk/wp-content/uploads/2024/05/BMW-M-Emblem.png"
                    ))
                }
            }
        }

    fun insertBmwEngine() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(200, 550)
            val randomDate = Random.nextInt(1998, 2024)
            val randomCode =  Random.nextInt(10, 89)
            BmwEngineRepository.insertBmwEngine(
                ItemUI.Item((randomCode/2).toDouble(), "M${randomCode}", random, randomDate)
            )
        }
    }


    fun deleteAllBmwEngine() {
        viewModelScope.launch(Dispatchers.IO) {
            BmwEngineRepository.deleteBmwEngine()
        }
    }
}