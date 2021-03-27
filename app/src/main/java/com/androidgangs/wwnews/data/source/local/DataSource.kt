package com.androidgangs.wwnews.data.source.local

import com.androidgangs.wwnews.data.model.UserModel

class DataSource(val usersDao: UsersDao):IDataSource {


    override suspend fun getUserPassword(email: String): String {
        return usersDao.getUserPassword(email)
    }

    override suspend fun addUser(userModel: UserModel): Long {
        return usersDao.upsert(userModel)
    }
}