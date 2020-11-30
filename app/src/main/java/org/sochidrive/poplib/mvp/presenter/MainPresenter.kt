package org.sochidrive.poplib.mvp.presenter

import moxy.MvpPresenter
import org.sochidrive.poplib.mvp.view.MainView
import org.sochidrive.poplib.navigation.Screens
import org.sochidrive.poplib.rxlearn.Operators
import ru.terrakok.cicerone.Router

class MainPresenter(val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UsersScreen())



        Operators().exec()

    }

    fun backClicked() {
        router.exit()
    }
}

