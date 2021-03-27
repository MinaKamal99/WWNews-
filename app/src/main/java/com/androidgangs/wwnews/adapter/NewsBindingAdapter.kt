package com.androidgangs.wwnews.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androidgangs.wwnews.data.model.ArticlesItem
import com.iti.mad41.taqs.adapter.NewsAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:articles")
fun aetArticles(listView: RecyclerView, items: List<ArticlesItem>?) {
    items?.let {
        listView.adapter as NewsAdapter
    }
}

@BindingAdapter("android:loadImage")
fun loadImage(imageView: ImageView, url: String) {
    url?.let{
        Picasso
            .get()
            .load(url)
    }
}