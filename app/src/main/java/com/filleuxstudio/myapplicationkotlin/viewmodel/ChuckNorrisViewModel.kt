package com.filleuxstudio.myapplicationkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filleuxstudio.myapplicationkotlin.data.ChuckNorrisQuoteRepository
import com.filleuxstudio.myapplicationkotlin.data.model.ChuckNorrisObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ChuckNorrisViewModel : ViewModel() {
    private val chuckNorrisQuoteRepository: ChuckNorrisQuoteRepository by lazy { ChuckNorrisQuoteRepository() }
    private val _quotes: Flow<List<ChuckNorrisObject>>
        get() = chuckNorrisQuoteRepository.selectAll()

    val quote = _quotes
    fun insertNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            chuckNorrisQuoteRepository.fetchData()
        }
    }
    fun deleteAllQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            chuckNorrisQuoteRepository.deleteAll()
        }
    }
}
