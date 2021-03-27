package com.androidgangs.wwnews.data.source.local

import com.androidgangs.wwnews.data.model.UserModel

interface IDataSource {
    suspend fun getUserPassword(email:String): String


    suspend fun addUser(userModel: UserModel): Long
}