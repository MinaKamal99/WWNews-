package com.androidgangs.wwnews.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "article")
data class ArticlesItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String? = null,
    @ColumnInfo(name = "author")
    val author: String? = null,
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String? = null,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "source")
    val source: Source? = null,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @ColumnInfo(name = "url")
    val url: String? = null,
    @ColumnInfo(name = "content")
    val content: String? = null
) : Parcelable