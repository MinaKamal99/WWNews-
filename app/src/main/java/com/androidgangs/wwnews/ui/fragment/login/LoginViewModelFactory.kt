package com.androidgangs.wwnews.ui.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidgangs.wwnews.data.repo.AuthRepo

class LoginViewModelFactory(val authRepo: AuthRepo) :ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>):T {
        return LoginViewModel(authRepo) as T
    }
}