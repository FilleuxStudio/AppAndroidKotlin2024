package com.filleuxstudio.myapplicationkotlin.data

import com.filleuxstudio.myapplicationkotlin.architecture.CustomApplication
import com.filleuxstudio.myapplicationkotlin.data.model.BMWEngineObjectEntity
import com.filleuxstudio.myapplicationkotlin.data.model.toRoomObject
import com.filleuxstudio.myapplicationkotlin.data.model.toUi
import com.filleuxstudio.myapplicationkotlin.model.ItemUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BMWEngineResp {
    fun populateMyList(): List<BMWEngineObjectEntity> {
        return listOf(
            BMWEngineObjectEntity(2022, "B58", 3.0, 382),     // BMW B58 (3.0L, 382ch)
            BMWEngineObjectEntity(2019, "S58", 3.0, 503),     // BMW S58 (3.0L, 503ch)
            BMWEngineObjectEntity(2015, "N55", 3.0, 300),     // BMW N55 (3.0L, 300ch)
            BMWEngineObjectEntity(2007, "N54", 3.0, 335),     // BMW N54 (3.0L, 335ch)
            BMWEngineObjectEntity(2003, "M54", 3.0, 231),     // BMW M54 (3.0L, 231ch)
            BMWEngineObjectEntity(2001, "S62", 4.9, 400),     // BMW S62 (4.9L, 400ch)
            BMWEngineObjectEntity(1992, "S50B32", 3.2, 321),  // BMW S50B32 (3.2L, 321ch)
            BMWEngineObjectEntity(1986, "M20B25", 2.5, 171),  // BMW M20B25 (2.5L, 171ch)
            BMWEngineObjectEntity(1980, "M30B34", 3.4, 218),  // BMW M30B34 (3.4L, 218ch)
            BMWEngineObjectEntity(1972, "M10B18", 1.8, 110)   // BMW M10B18 (1.8L, 110ch)
        )
    }

    private val bmwEngineDao = CustomApplication.instance.mApplicationDatabase.BMWEngineDao()


    fun selectAllBmwEngine(): Flow<List<ItemUI.Item>> {
        return bmwEngineDao.selectAll().map {
            it.toUi()
        }
    }


    fun insertBmwEngine(androidObject: ItemUI.Item) {
        bmwEngineDao.insert(androidObject.toRoomObject())
    }


    fun deleteBmwEngine() {
        bmwEngineDao.deleteAll()
    }

}