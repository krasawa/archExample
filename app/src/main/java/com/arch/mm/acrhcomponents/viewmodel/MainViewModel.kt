package com.arch.mm.acrhcomponents.viewmodel

import android.arch.lifecycle.*
import android.support.annotation.NonNull
import android.util.Log
import com.arch.mm.acrhcomponents.CustomApplication
import com.arch.mm.acrhcomponents.network.response.Weather
import com.arch.mm.acrhcomponents.network.response.WeatherForTodayResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val application: CustomApplication) : AndroidViewModel(application) {

    private var weatherData: MutableLiveData<Weather>? = null
    private val TAG = this::class.simpleName

    fun getWeatherForCity(city: String): LiveData<Weather>? {
        if (weatherData == null) {
            weatherData = MutableLiveData()
            requestWeather(city)
        }
        return weatherData
    }

    private fun requestWeather(city: String) {
        application.networkManager
                .fetchTodayWeather(city)
                .enqueue(object : Callback<WeatherForTodayResponse> {
                    override fun onFailure(call: Call<WeatherForTodayResponse>?, t: Throwable?) {
                        Log.e(TAG, "Weather request error")
                        t?.printStackTrace()
                    }

                    override fun onResponse(call: Call<WeatherForTodayResponse>?, response: Response<WeatherForTodayResponse>?) {
                        Log.d(TAG, "Weather response = $response")
                        if (response != null) {
                            val weather = response.body()!!.weather[0]
                            weather.city = city
                            weatherData?.value = weather

                            application.dataManager.saveWeather(weather)
                        }
                    }
                })
    }

    override fun onCleared() {
        Log.d(TAG, "Cleared main ViewModel")
    }
}

class MainViewModelFactory(@NonNull private val application: CustomApplication) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(application) as T
    }
}