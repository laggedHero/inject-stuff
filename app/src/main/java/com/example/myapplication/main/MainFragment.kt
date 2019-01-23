package com.example.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : MainFragmentContract.View, DaggerFragment() {

    @Inject
    lateinit var presenter: MainFragmentContract.Presenter

    private var someTextView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        someTextView = view.findViewById(R.id.some_text_view)

        view.findViewById<View>(R.id.one_button)?.setOnClickListener { presenter.onEphemeral() }
        view.findViewById<View>(R.id.another_button)?.setOnClickListener { presenter.onNonEphemeral() }
        view.findViewById<View>(R.id.moar_button)?.setOnClickListener { presenter.onNextScreen() }

        presenter.bind(this)
    }

    override fun onDestroyView() {
        presenter.release()
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        presenter.load()
    }

    override fun show(message: String) {
        someTextView?.text = message
    }
}