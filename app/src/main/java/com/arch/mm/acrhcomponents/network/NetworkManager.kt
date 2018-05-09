package com.arch.mm.acrhcomponents.network

import android.arch.lifecycle.LifecycleObserver
import com.arch.mm.acrhcomponents.network.response.WeatherForTodayResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager: LifecycleObserver {

    private var weatherService: WeatherService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        weatherService = retrofit.create(WeatherService::class.java)
    }

    fun fetchTodayWeather(city: String): Call<WeatherForTodayResponse> {
        return weatherService.fetchTodayWeather(city)
    }
}