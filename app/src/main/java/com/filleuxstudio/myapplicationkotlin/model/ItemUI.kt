package com.filleuxstudio.myapplicationkotlin.model

import android.graphics.ImageDecoder
import com.filleuxstudio.myapplicationkotlin.data.model.BMWEngineObject

sealed interface ItemUI {

        data class Item(
            val displacement: Double,
            val engineCode: String,
            val horsepower: Int
        ) : ItemUI

        data class Header(
            val year: Int,
        ) : ItemUI

    data class Footer(
        val pub: String,
    ): ItemUI
}

fun List<BMWEngineObject>.toUi(): List<ItemUI.Item> {
    return map { currentAndroidObject ->
        ItemUI.Item(
            displacement = currentAndroidObject.displacement,
            engineCode = currentAndroidObject.engineCode,
            horsepower = currentAndroidObject.horsepower,
        )
    }
}
