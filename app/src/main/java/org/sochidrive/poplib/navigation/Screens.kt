package org.sochidrive.poplib.navigation

import org.sochidrive.poplib.ui.fragment.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen() : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }
}