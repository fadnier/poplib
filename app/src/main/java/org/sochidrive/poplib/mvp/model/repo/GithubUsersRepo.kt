package org.sochidrive.poplib.mvp.model.repo

import org.sochidrive.poplib.mvp.model.entity.GithubUser

class GithubUsersRepo {

    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5"),
        GithubUser("login6")
    )

    fun getUsers(): List<GithubUser> {
        return repositories
    }
}