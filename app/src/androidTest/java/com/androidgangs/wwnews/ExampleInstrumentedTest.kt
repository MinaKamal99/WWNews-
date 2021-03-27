package com.androidgangs.wwnews

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.androidgangs.wwnews.data.model.UserModel
import com.androidgangs.wwnews.data.source.local.NewsDatabase
import com.androidgangs.wwnews.util.MyApplication
import kotlinx.coroutines.runBlocking
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@RunWith(AndroidJUnit4::class)

class RoomTest{
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    lateinit var newsDatabase: NewsDatabase
    @Before
    fun initDb(){
        newsDatabase = Room.inMemoryDatabaseBuilder(getApplicationContext<Application>(),NewsDatabase::class.java)
            .allowMainThreadQueries().build()
    }
    @Test
     fun insertAndGetData() = runBlocking{


        val user = UserModel("mahmoud@gmail.com","123456","mahmoud")

        newsDatabase.userDao().upsert(user)

        val password = newsDatabase.userDao().getUserPassword("mahmoud@gmail.com")

        assertEquals("123456",password)

    }
    @After
    fun colseDB() = newsDatabase.close()

}