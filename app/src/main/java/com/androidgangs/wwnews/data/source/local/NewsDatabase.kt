package com.androidgangs.wwnews.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidgangs.wwnews.data.model.UserModel

@Database(entities = arrayOf(UserModel::class), version = 1)
abstract class NewsDatabase:RoomDatabase() {

    abstract fun userDao(): UsersDao


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        // @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getLocalData(context: Context): NewsDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE
                ?: synchronized(this) {
                    val instance = Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "news.db").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                    // return instance
                    instance
                }
        }
    }
}

