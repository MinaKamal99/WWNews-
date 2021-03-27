package com.androidgangs.wwnews.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserModel(@PrimaryKey
    var email:String="",var password:String="",var fname:String)
