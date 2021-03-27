package com.androidgangs.wwnews.data.repo

import com.androidgangs.wwnews.data.model.UserModel

interface IAuthRepo {
    suspend fun savedData(userModel: UserModel): Long
    suspend fun getAuthData(email: String):String
}