package com.filleuxstudio.myapplicationkotlin.data

import com.filleuxstudio.myapplicationkotlin.architecture.CustomApplication
import com.filleuxstudio.myapplicationkotlin.architecture.RetrofitBuilder
import com.filleuxstudio.myapplicationkotlin.data.model.ChuckNorrisObject
import com.filleuxstudio.myapplicationkotlin.data.model.toRoom
import com.filleuxstudio.myapplicationkotlin.data.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckNorrisQuoteRepository {


    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.ChuckNorrisDao()

    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }


    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }


    fun selectAll(): Flow<List<ChuckNorrisObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toUi()
        }
    }
}
