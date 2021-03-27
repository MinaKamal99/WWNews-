package com.androidgangs.wwnews.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iti.mad41.taqs.adapter.DailyWeatherAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:loadImage")
fun loadImage(imageView: ImageView, url: String) {
    url?.let{
        Picasso
            .get()
            .load(url)
    }
}