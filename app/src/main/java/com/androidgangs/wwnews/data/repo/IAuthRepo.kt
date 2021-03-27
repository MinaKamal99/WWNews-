package com.androidgangs.wwnews.data.repo

import com.androidgangs.wwnews.data.model.UserModel

interface IAuthRepo {
    suspend fun savedData(userModel: UserModel)
    suspend fun getAuthData(email: String): String
}