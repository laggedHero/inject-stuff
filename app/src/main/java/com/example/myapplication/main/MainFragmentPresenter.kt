package com.example.myapplication.main

import com.example.myapplication.stuff.Dialogs
import com.example.myapplication.stuff.Navigator

class MainFragmentPresenter(
    private val navigator: Navigator,
    private val dialogs: Dialogs
) : MainFragmentContract.Presenter {

    private var view: MainFragmentContract.View? = null

    override fun bind(view: MainFragmentContract.View) {
        this.view = view
    }

    override fun release() {
        view = null
    }

    override fun load() {
        view?.show("LOL")
    }

    override fun onEphemeral() {
        dialogs.showEphemeral("LOLOL")
    }

    override fun onNonEphemeral() {
        dialogs.showNonEphemeral("TROLOLOLOLOOOOO")
    }

    override fun onNextScreen() {
        navigator.showAnotherScreen()
    }
}