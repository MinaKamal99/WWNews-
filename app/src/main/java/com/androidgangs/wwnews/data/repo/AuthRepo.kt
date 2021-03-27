package com.androidgangs.wwnews.data.repo

import com.androidgangs.wwnews.data.model.UserModel
import com.androidgangs.wwnews.data.source.local.DataSource

class AuthRepo(val dataSource: DataSource) : IAuthRepo {

    override suspend fun savedData(userModel: UserModel): Long {
        return dataSource.usersDao.upsert(userModel)
    }

    override suspend fun getAuthData(email:String): String {
        return dataSource.usersDao.getUserPassword(email)
    }
}