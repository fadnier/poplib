package org.sochidrive.poplib.mvp.presenter

import moxy.MvpPresenter
import org.sochidrive.poplib.mvp.model.repo.GithubUsersRepo
import org.sochidrive.poplib.mvp.view.UserView
import ru.terrakok.cicerone.Router

class UserPresenter (val router: Router, val usersRepo: GithubUsersRepo, val pos: Int) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        viewState.displayUser(usersRepo.getUsers()[pos].login)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}