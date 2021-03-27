package com.androidgangs.wwnews.ui.fragment.login

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidgangs.wwnews.data.model.UserModel
import com.androidgangs.wwnews.data.repo.AuthRepo
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class LoginViewModel(var authRepo: AuthRepo) : ViewModel() {
    var user: UserModel? = null
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
     var errorLveData= MutableLiveData<String>()

     var gotoHomeLiveData= MutableLiveData<Boolean>()

    private  val TAG = "LoginViewModel"

    fun onClickSave() {

        val resultValidation = validate(user?.email, user?.password)
        if (resultValidation) {
            viewModelScope.launch {
                val result = authRepo.getAuthData(user!!.email)
                if (result.isNotEmpty()) {
                    Log.i(TAG, "onClickSave:  in if result not empty")
                    gotoHomeLiveData.value = true
                } else {
                    Log.i(TAG, "onClickSave: else of result is empty")
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

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}