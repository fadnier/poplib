package org.sochidrive.poplib.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.poplib.R
import org.sochidrive.poplib.mvp.model.repo.GithubUsersRepo
import org.sochidrive.poplib.mvp.presenter.UsersPresenter
import org.sochidrive.poplib.mvp.view.UsersView
import org.sochidrive.poplib.ui.App
import org.sochidrive.poplib.ui.BackButtonListener
import org.sochidrive.poplib.ui.adapter.UsersRvAdapter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter by moxyPresenter {
        UsersPresenter(App.instance.router, GithubUsersRepo())
    }

    val adapter by lazy {
        UsersRvAdapter(presenter.usersListPresenter)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_users, null)

    override fun init() {
        rv_users.layoutManager = LinearLayoutManager(requireContext())
        rv_users.adapter = adapter
    }

    override fun updateUsersList() {
        adapter.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backClick()

}