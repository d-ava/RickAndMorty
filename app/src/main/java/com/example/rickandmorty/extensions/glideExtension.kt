package com.example.rickandmorty.extensions


import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.rickandmorty.R

fun ImageView.glideExtension(img: String?) {
    if (!img.isNullOrEmpty()) {
        Glide.with(context).load(img).error(R.drawable.ic_baseline_error_outline_24)
            .into(this)

    } else setImageResource(R.drawable.ic_baseline_landscape_24)


}