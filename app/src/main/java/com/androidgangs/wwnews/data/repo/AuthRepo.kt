package com.androidgangs.wwnews.data.repo

import com.androidgangs.wwnews.data.model.UserModel
import com.androidgangs.wwnews.data.source.local.DataSource

class AuthRepo(val dataSource: DataSource) {

    suspend fun savedData(userModel: UserModel){
        dataSource.usersDao.upsert(userModel)
    }

    suspend fun getAuthData(email:String){
        dataSource.usersDao.getUserPassword(email)
    }
}