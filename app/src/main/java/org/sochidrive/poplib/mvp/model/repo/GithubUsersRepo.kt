package org.sochidrive.poplib.mvp.model.repo

import io.reactivex.rxjava3.core.Observable
import org.sochidrive.poplib.mvp.model.entity.GithubUser

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers()  = Observable.fromCallable { return@fromCallable repositories }

}
