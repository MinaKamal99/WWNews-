package com.androidgangs.wwnews.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import com.androidgangs.wwnews.data.model.ArticlesItem

@Dao
interface ArticlesDao {
    @Insert(entity = ArticlesItem::class)
    suspend fun insertArticle(article: ArticlesItem)
}