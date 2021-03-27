package com.androidgangs.wwnews.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserModel(@PrimaryKey
    val email:String,val password:String,val fname:String)
