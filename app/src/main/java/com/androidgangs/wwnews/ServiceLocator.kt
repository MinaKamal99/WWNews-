package com.androidgangs.wwnews

import android.app.Application
import com.androidgangs.wwnews.data.repo.AuthRepo
import com.androidgangs.wwnews.data.repo.IAuthRepo
import com.androidgangs.wwnews.data.source.local.DataSource
import com.androidgangs.wwnews.data.source.local.NewsDatabase
import com.androidgangs.wwnews.util.MyApplication
import java.lang.Appendable

object ServiceLocator {
    fun createRepo(application: Application):AuthRepo{
        val newsDatabase = NewsDatabase.getLocalData(application).userDao()
        val iDataSource = DataSource(newsDatabase)
        return AuthRepo(iDataSource)

    }
}