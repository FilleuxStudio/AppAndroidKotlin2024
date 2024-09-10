package com.filleuxstudio.myapplicationkotlin.model

// Data class représentant un moteur BMW
data class BMWEngine(
    val year: Int,          // Année du moteur
    val engineCode: String, // Code moteur
    val displacement: Double, // Cylindrée en litres
    val horsepower: Int     // Puissance en chevaux (ch)
)

// Générer une liste des différents moteurs BMW
val bmwEngines = listOf(
    BMWEngine(2022, "B58", 3.0, 382),     // BMW B58 (3.0L, 382ch)
    BMWEngine(2019, "S58", 3.0, 503),     // BMW S58 (3.0L, 503ch)
    BMWEngine(2015, "N55", 3.0, 300),     // BMW N55 (3.0L, 300ch)
    BMWEngine(2007, "N54", 3.0, 335),     // BMW N54 (3.0L, 335ch)
    BMWEngine(2003, "M54", 3.0, 231),     // BMW M54 (3.0L, 231ch)
    BMWEngine(2001, "S62", 4.9, 400),     // BMW S62 (4.9L, 400ch)
    BMWEngine(1992, "S50B32", 3.2, 321),  // BMW S50B32 (3.2L, 321ch)
    BMWEngine(1986, "M20B25", 2.5, 171),  // BMW M20B25 (2.5L, 171ch)
    BMWEngine(1980, "M30B34", 3.4, 218),  // BMW M30B34 (3.4L, 218ch)
    BMWEngine(1972, "M10B18", 1.8, 110)   // BMW M10B18 (1.8L, 110ch)
)

fun main() {
    // Afficher la liste des moteurs BMW
    bmwEngines.forEach { engine ->
        println("Année: ${engine.year}, Code moteur: ${engine.engineCode}, Cylindrée: ${engine.displacement}L, Puissance: ${engine.horsepower}ch")
    }
}