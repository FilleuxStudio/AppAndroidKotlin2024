package com.filleuxstudio.myapplicationkotlin.data.model

data class BMWEngineObject(
    val year: Int,          // Année du moteur
    val engineCode: String, // Code moteur
    val displacement: Double, // Cylindrée en litres
    val horsepower: Int     // Puissance en chevaux (ch)
    )