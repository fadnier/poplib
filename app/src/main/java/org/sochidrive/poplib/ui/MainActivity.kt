package org.sochidrive.poplib.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.sochidrive.poplib.R
import org.sochidrive.poplib.mvp.model.Model
import org.sochidrive.poplib.mvp.presenter.Presenter
import org.sochidrive.poplib.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    val presenter = Presenter(Model(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener1 = View.OnClickListener {
            presenter.counter1Click()
        }
        val listener2 = View.OnClickListener {
            presenter.counter2Click()
        }
        val listener3 = View.OnClickListener {
            presenter.counter3Click()
        }

        btn_counter1.setOnClickListener(listener1)
        btn_counter2.setOnClickListener(listener2)
        btn_counter3.setOnClickListener(listener3)

    }

    override fun setButton1Text(text: String) {
        btn_counter1.text = text
    }

    override fun setButton2Text(text: String) {
        btn_counter2.text = text
    }

    override fun setButton3Text(text: String) {
        btn_counter3.text = text
    }

}