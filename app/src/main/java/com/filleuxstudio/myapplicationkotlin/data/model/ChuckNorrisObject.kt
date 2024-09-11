package com.filleuxstudio.myapplicationkotlin.data.model

data class ChuckNorrisObject(
    val quote: String,
    val iconUrl: String,
)

fun List<ChuckNorrisEntity>.toUi(): List<ChuckNorrisObject> {
    return map { eachEntity ->
        ChuckNorrisObject(
            quote = eachEntity.quote,
            iconUrl = eachEntity.iconUrl,
        )
    }
}
