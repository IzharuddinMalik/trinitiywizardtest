package com.izharuddin1997.trinitywizard

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TrinityApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
