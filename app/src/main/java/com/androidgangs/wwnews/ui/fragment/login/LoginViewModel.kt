package com.androidgangs.wwnews.ui.fragment.login

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidgangs.wwnews.data.model.UserModel
import com.androidgangs.wwnews.data.repo.AuthRepo
import kotlinx.coroutines.launch

class LoginViewModel(var authRepo: AuthRepo) : ViewModel() {
    var user: UserModel? = null
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    lateinit var errorLveData: MutableLiveData<String>

    lateinit var gotoHomeLiveData: MutableLiveData<Boolean>

    fun onClickSave() {

        val resultValidation = validate(user?.email, user?.password)
        if (resultValidation) {
            viewModelScope.launch {
                val result = authRepo.getAuthData(user!!.email)
                if (result.isNotEmpty()) {
                    gotoHomeLiveData.value = true
                } else {
                    errorLveData.value = "Error Email"
                }
            }

        }
    }

    fun validate(email: String?, password: String?): Boolean {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            errorLveData.value = "Error invalid username or password"
            return false
        } else if (user?.email?.matches(emailPattern.toRegex()) == false) {
            errorLveData.value = "Error Email "
            return false
        } else {
            return true

        }

    }
}