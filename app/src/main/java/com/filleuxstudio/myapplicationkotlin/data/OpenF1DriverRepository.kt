package com.filleuxstudio.myapplicationkotlin.data

import com.filleuxstudio.myapplicationkotlin.architecture.CustomApplication
import com.filleuxstudio.myapplicationkotlin.architecture.RetrofitBuilderOpenF1
import com.filleuxstudio.myapplicationkotlin.data.model.OpenF1DriverObject
import com.filleuxstudio.myapplicationkotlin.data.model.toRoomEntities
import com.filleuxstudio.myapplicationkotlin.data.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OpenF1DriverRepository {
    private val openF1DriverDao = CustomApplication.instance.mApplicationDatabase.OpenF1DriverDao()


    suspend fun fetchData() {
        //openF1DriverDao.insertDriver(RetrofitBuilderOpenF1.getDriversServiceEndPoint().getRandomF1().toRoom())
        val drivers = RetrofitBuilderOpenF1.getDriversService().getDrivers(9158)
        val driverEntities = drivers.toRoomEntities()
        openF1DriverDao.insertAllDrivers(driverEntities)
    }


    fun deleteAll() {
        openF1DriverDao.deleteAllDrivers()
    }


    fun selectAll(): Flow<List<OpenF1DriverObject>> {
        return openF1DriverDao.getAllDrivers().map { list ->
            list.toUi()
        }
    }

}