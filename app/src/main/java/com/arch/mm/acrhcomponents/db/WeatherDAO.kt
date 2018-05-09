package com.arch.mm.acrhcomponents.db

import android.arch.persistence.room.*
import com.arch.mm.acrhcomponents.network.response.Weather

@Dao
interface WeatherDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(weather: Weather)

    @Delete
    fun delete(weather: Weather)

    @Query("SELECT * FROM weather")
    fun findWeather(): Weather
}