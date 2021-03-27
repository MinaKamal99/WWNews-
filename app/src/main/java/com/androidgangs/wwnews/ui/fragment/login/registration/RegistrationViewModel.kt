package com.androidgangs.wwnews.ui.fragment.login.registration

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidgangs.wwnews.data.model.UserModel
import com.androidgangs.wwnews.data.repo.AuthRepo
import com.androidgangs.wwnews.data.repo.IAuthRepo
import com.androidgangs.wwnews.data.source.local.DataSource
import com.androidgangs.wwnews.data.source.local.IDataSource
import com.androidgangs.wwnews.data.source.local.NewsDatabase
import com.androidgangs.wwnews.data.source.local.UsersDao
import com.androidgangs.wwnews.util.MyApplication
import kotlinx.coroutines.*

class RegistrationViewModel(val authRepo: AuthRepo) : ViewModel() {


    fun registration(userModel: UserModel) {
        var corotiune =
            CoroutineExceptionHandler { _, exception -> errorLiveData.postValue(exception.message) }

            .launch {
            authRepo.savedData(userModel)

        }
    }
    val errorLiveData = MutableLiveData<String>()
    val loadingLiveData = MutableLiveData<Boolean>()
    val userLiveData = MutableLiveData<UserModel>()

}