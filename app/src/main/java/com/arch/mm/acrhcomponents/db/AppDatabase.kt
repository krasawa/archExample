package com.arch.mm.acrhcomponents.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.arch.mm.acrhcomponents.network.response.Weather

@Database(entities = [Weather::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getWeatherDao(): WeatherDAO
}