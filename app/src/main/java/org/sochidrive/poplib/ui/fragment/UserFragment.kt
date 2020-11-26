package org.sochidrive.poplib.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.poplib.R
import org.sochidrive.poplib.mvp.model.repo.GithubUsersRepo
import org.sochidrive.poplib.mvp.presenter.UserPresenter
import org.sochidrive.poplib.mvp.view.UserView
import org.sochidrive.poplib.ui.App
import org.sochidrive.poplib.ui.BackButtonListener

class UserFragment(pos: Int) : MvpAppCompatFragment(), UserView, BackButtonListener {

    companion object {
        fun newInstance(pos: Int) = UserFragment(pos)
    }

    val presenter by moxyPresenter {
        UserPresenter(App.instance.router, GithubUsersRepo(), pos)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_user, null)

    override fun init() {
        //displayUser("333")
    }

    override fun displayUser(user: String) {
        textView.text = user
    }

    override fun backPressed() = presenter.backClick()

}