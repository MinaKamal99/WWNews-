package com.androidgangs.wwnews.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androidgangs.wwnews.data.model.UserModel

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(userModel: UserModel)

    @Query("select password from users where email = :email")
     suspend fun getUserPassword(email:String):String
}