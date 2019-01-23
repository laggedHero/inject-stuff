package com.example.myapplication

import com.example.myapplication.injection.DaggerInjector
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerInjector.builder()
            .application(this)
            .build()
    }
}