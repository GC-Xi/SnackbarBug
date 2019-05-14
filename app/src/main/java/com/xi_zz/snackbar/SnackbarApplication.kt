package com.xi_zz.snackbar

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class SnackbarApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LeakCanary.install(this)
    }
}