package com.androidgangs.wwnews.ui.fragment.login.registration

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidgangs.wwnews.data.model.UserModel
import com.androidgangs.wwnews.data.repo.AuthRepo
import kotlinx.coroutines.*

class RegistrationViewModel(val authRepo: AuthRepo) : ViewModel() {

    val user:UserModel = UserModel()

   suspend fun registration(email:String,password:String,cPassword:String):Boolean {
       var success = false
        if (!email.isNullOrEmpty()){
                user.email = email
                user.password = password
                val savedData = authRepo.savedData(user)
                if (savedData > 0){

                    success = true
                }else{
                    errorLiveData.setValue("This User exists")
                }


        }
        return success
    }
    fun register(email:String,password:String,cPassword:String){
        viewModelScope.launch {
            val successRegister = registration(email,password,cPassword)
            if (successRegister){
                successMutableList.setValue(true)
            } else{
                successMutableList.setValue(false)
            }
        }
    }
    val errorLiveData = MutableLiveData<String>()
    val loadingLiveData = MutableLiveData<Boolean>()
    val successMutableList = MutableLiveData<Boolean>()

}