package com.arch.mm.acrhcomponents.network

import com.arch.mm.acrhcomponents.network.response.WeatherForTodayResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    companion object {
        const val APP_ID = "appid=0b8b3b987e725cddd4fa20974ae22bd8"
    }

    @GET("/data/2.5/weather?$APP_ID")
    fun fetchTodayWeather(@Query("q") city: String): Call<WeatherForTodayResponse>
}