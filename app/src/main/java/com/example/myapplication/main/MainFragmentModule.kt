package com.example.myapplication.main

import com.example.myapplication.injection.fragment.FragmentScope
import com.example.myapplication.stuff.Dialogs
import com.example.myapplication.stuff.Navigator
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {

    @Provides
    @FragmentScope
    fun providesPresenter(navigator: Navigator, dialogs: Dialogs): MainFragmentContract.Presenter {
        return MainFragmentPresenter(navigator, dialogs)
    }
}