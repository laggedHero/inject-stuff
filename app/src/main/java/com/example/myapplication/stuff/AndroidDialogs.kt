package com.example.myapplication.stuff

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AndroidDialogs(private val activity: AppCompatActivity) : Dialogs {
    override fun showEphemeral(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun showNonEphemeral(message: String) {
        AlertDialog.Builder(activity)
            .setMessage(message)
            .create()
            .show()
    }
}