package com.arch.mm.acrhcomponents.network.response

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

data class WeatherForTodayResponse(val coord: Coord, val weather: List<Weather>, val main: WeatherMain, val visibility: Int)

data class Coord(val lon:Double, val lat:Double)

@Entity
data class Weather(@PrimaryKey val id: Int, val main: String, val description: String, val icon: String, var city: String)

data class WeatherMain(val temp: Double, val pressure: Int, val humidity: Int, val temp_min: Double, val temp_max: Double)