package com.example.myapplication.main

interface MainFragmentContract {
    interface View {
        fun show(message: String)
    }

    interface Presenter {
        fun bind(view: View)
        fun release()
        fun load()
        fun onEphemeral()
        fun onNonEphemeral()
        fun onNextScreen()
    }
}