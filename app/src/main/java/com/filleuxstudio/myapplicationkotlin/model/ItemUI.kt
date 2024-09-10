package com.filleuxstudio.myapplicationkotlin.model

import android.graphics.ImageDecoder

sealed interface ItemUI {

        data class MyAndroidObject(
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