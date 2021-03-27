package com.androidgangs.wwnews.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:loadImage")
fun loadImage(imageView: ImageView, url: String) {
    url?.let{
        Picasso
            .get()
            .load(url)
    }
}