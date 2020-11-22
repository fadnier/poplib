package org.sochidrive.poplib.mvp.presenter

import org.sochidrive.poplib.mvp.model.Model
import org.sochidrive.poplib.mvp.view.MainView

class Presenter(val model: Model, val mainView: MainView) {

    fun counter1Click() {
        val nextValue = model.next(0)
        mainView.setButton1Text(nextValue.toString())
    }

    fun counter2Click() {
        val nextValue = model.next(1)
        mainView.setButton2Text(nextValue.toString())
    }

    fun counter3Click() {
        val nextValue = model.next(2)
        mainView.setButton3Text(nextValue.toString())
    }
}