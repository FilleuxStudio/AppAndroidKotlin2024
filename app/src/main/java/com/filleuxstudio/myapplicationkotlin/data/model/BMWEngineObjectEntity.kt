package com.filleuxstudio.myapplicationkotlin.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.filleuxstudio.myapplicationkotlin.model.ItemUI
import kotlinx.coroutines.yield

@Entity(tableName = "android_version_object_table")
data class BMWEngineObjectEntity(
    @ColumnInfo(name = "year")
    val year: Int,          // Année du moteur
    @ColumnInfo(name = "engineCode")
    val engineCode: String, // Code moteur
    @ColumnInfo(name = "displacement")
    val displacement: Double, // Cylindrée en litres
    @ColumnInfo(name = "horsepower")
    val horsepower: Int,     // Puissance en chevaux (ch)
    ){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

fun ItemUI.Item.toRoomObject(): BMWEngineObjectEntity {
    return BMWEngineObjectEntity(
        engineCode = engineCode,
        displacement = displacement,
        horsepower = horsepower,
        year = year
    )
}


fun List<BMWEngineObjectEntity>.toUi(): List<ItemUI.Item> {
    return map { eachItem ->
        ItemUI.Item(
            engineCode = eachItem.engineCode,
            displacement = eachItem.displacement,
            horsepower = eachItem.horsepower,
            year = eachItem.year
        )
    }
}

