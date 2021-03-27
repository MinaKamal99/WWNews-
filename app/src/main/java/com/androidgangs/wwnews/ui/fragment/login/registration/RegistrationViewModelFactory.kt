package com.androidgangs.wwnews.ui.fragment.login.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidgangs.wwnews.data.repo.AuthRepo

class RegistrationViewModelFactory(val authRepo: AuthRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegistrationViewModel(authRepo) as T
    }
}