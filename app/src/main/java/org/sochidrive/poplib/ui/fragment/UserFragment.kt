package org.sochidrive.poplib.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.poplib.R
import org.sochidrive.poplib.mvp.model.entity.GithubUser
import org.sochidrive.poplib.mvp.presenter.UserPresenter
import org.sochidrive.poplib.mvp.view.UserView
import org.sochidrive.poplib.ui.App
import org.sochidrive.poplib.ui.BackButtonListener

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    companion object {
        private const val USER_ARG = "user"

        fun newInstance(user: GithubUser) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, user)
            }
        }
    }

    val presenter: UserPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER_ARG) as GithubUser
        UserPresenter(App.instance.router, user)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_user, null)

    override fun setLogin(text: String) {
        tv_login.text = text
    }

    override fun backPressed() = presenter.backPressed()
}