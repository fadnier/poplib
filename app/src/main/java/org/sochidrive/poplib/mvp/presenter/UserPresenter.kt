package org.sochidrive.poplib.mvp.presenter

import moxy.MvpPresenter
import org.sochidrive.poplib.mvp.model.entity.GithubUser
import org.sochidrive.poplib.mvp.view.UserView
import ru.terrakok.cicerone.Router

class UserPresenter(val router: Router, val user: GithubUser) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(user.login)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
