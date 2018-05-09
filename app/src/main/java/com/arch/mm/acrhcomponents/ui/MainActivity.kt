package com.arch.mm.acrhcomponents.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.arch.mm.acrhcomponents.CustomApplication
import com.arch.mm.acrhcomponents.R
import com.arch.mm.acrhcomponents.network.response.Weather
import com.arch.mm.acrhcomponents.viewmodel.MainViewModel
import com.arch.mm.acrhcomponents.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainModel = ViewModelProviders.of(this, MainViewModelFactory(application as CustomApplication)).get(MainViewModel::class.java)
        mainModel.getWeatherForCity("Kyiv")?.observe(this, Observer<Weather> {
            Log.d(TAG, "Found weather in observer = $it")
        })
    }
}
