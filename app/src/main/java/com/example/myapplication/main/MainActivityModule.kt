package com.example.myapplication.main

import com.example.myapplication.injection.activity.ActivityScope
import com.example.myapplication.injection.fragment.FragmentScope
import com.example.myapplication.stuff.AndroidDialogs
import com.example.myapplication.stuff.AndroidNavigator
import com.example.myapplication.stuff.Dialogs
import com.example.myapplication.stuff.Navigator
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeMainFragment(): MainFragment

    @Module
    companion object {
        @Provides
        @ActivityScope
        @JvmStatic
        fun providesNavigator(activity: MainActivity): Navigator {
            return AndroidNavigator(activity)
        }

        @Provides
        @ActivityScope
        @JvmStatic
        fun providesDialog(activity: MainActivity): Dialogs {
            return AndroidDialogs(activity)
        }
    }
}