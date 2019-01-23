package com.example.myapplication.injection

import android.app.Application
import com.example.myapplication.MyApplication
import com.example.myapplication.injection.activity.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class
    ]
)
interface Injector : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        fun build(): Injector

        @BindsInstance
        fun application(application: Application): Builder
    }
}