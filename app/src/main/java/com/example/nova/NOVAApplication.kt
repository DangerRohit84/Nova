package com.example.nova

import android.app.Application
import android.util.Log

class NOVAApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("NOVA", "NOVA Application Started")
    }
}
