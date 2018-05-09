package com.arch.mm.acrhcomponents.db

import android.arch.persistence.room.Room
import com.arch.mm.acrhcomponents.CustomApplication
import com.arch.mm.acrhcomponents.network.response.Weather
import org.jetbrains.anko.doAsync

class DatabaseManager(application: CustomApplication) {
    private var db: AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "arch_db").build()

    fun saveWeather(weather: Weather) {
        doAsync {
            db.getWeatherDao().save(weather)
        }
    }
}