package org.sochidrive.poplib.mvp.presenter

import moxy.MvpPresenter
import org.sochidrive.poplib.mvp.model.entity.GithubUser
import org.sochidrive.poplib.mvp.model.repo.GithubUsersRepo
import org.sochidrive.poplib.mvp.presenter.list.IUserListPresenter
import org.sochidrive.poplib.mvp.view.UsersView
import org.sochidrive.poplib.mvp.view.list.UserItemView
import org.sochidrive.poplib.navigation.Screens
import ru.terrakok.cicerone.Router

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) : MvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(Screens.UserScreen(user))
        }
    }

    fun loadData() {
        usersRepo.getUsers()
            .subscribe({
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(it)
                viewState.updateList()
            }, {
                it.printStackTrace()
            })
        //val users = usersRepo.getUsers()
        //usersListPresenter.users.addAll(users)
        //viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}
