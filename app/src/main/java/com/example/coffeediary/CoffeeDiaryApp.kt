package com.example.coffeediary

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoffeeDiaryApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}