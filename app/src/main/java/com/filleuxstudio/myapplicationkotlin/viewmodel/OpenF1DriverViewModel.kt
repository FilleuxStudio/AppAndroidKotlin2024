package com.filleuxstudio.myapplicationkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filleuxstudio.myapplicationkotlin.data.OpenF1DriverRepository
import com.filleuxstudio.myapplicationkotlin.data.model.OpenF1DriverObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class OpenF1DriverViewModel: ViewModel() {
    private val openF1DriverRepository: OpenF1DriverRepository by lazy { OpenF1DriverRepository() }
    private val _openf1: Flow<List<OpenF1DriverObject>>
    get() = openF1DriverRepository.selectAll()

    val openf1 = _openf1
    fun insertAllDriver() {
        viewModelScope.launch(Dispatchers.IO) {
            openF1DriverRepository.fetchData()
        }
    }
    fun  deleteAllDriver() {
        viewModelScope.launch(Dispatchers.IO) {
            openF1DriverRepository.deleteAll()
        }
    }


}