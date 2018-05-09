package com.arch.mm.acrhcomponents

import android.app.Application
import com.arch.mm.acrhcomponents.db.DatabaseManager
import com.arch.mm.acrhcomponents.network.NetworkManager

class CustomApplication: Application() {

    lateinit var networkManager: NetworkManager
    lateinit var dataManager: DatabaseManager

    override fun onCreate() {
        super.onCreate()

        networkManager = NetworkManager()
        dataManager = DatabaseManager(this)
    }
}