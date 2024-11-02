package com.ideasapp.messenger.presentation.ui

class AppRoute {
    private object Route {
        const val LOGIN = "login"
        const val SIGNUP = "sign_up"
    }

    sealed class Screen(val route: String) {
        data object Login: Screen(Route.LOGIN)
        data object SignUp: Screen(Route.SIGNUP)
    }
}