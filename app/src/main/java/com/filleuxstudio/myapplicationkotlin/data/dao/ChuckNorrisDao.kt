package com.filleuxstudio.myapplicationkotlin.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.filleuxstudio.myapplicationkotlin.data.model.ChuckNorrisEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow

@Dao
interface ChuckNorrisDao {


    @Query("SELECT * FROM chuck_norris_table ORDER BY quote ASC")
    fun selectAll(): Flow<List<ChuckNorrisEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisEntity: ChuckNorrisEntity)


    @Query("DELETE FROM chuck_norris_table")
    fun deleteAll()
}

/*data class ChuckNorrisDto(
    @Expose
    @SerializedName("value")
    val quote: String,


    @Expose
    @SerializedName("icon_url")
    val iconUrl: String
)


fun ChuckNorrisDto.toRoom(): ChuckNorrisEntity {
    return ChuckNorrisEntity(
        quote = quote,
        iconUrl = iconUrl
    )
}*/
