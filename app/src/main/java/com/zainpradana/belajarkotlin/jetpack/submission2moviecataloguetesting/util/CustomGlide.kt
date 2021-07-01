package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation

object CustomGlide {
    fun setImage(context: Context, drawable: Int, imageView: ImageView){
        Glide.with(context)
            .load(drawable)
            .apply(RequestOptions().override(150, 150))
            .into(imageView)
    }

    fun setBlurImage(context: Context, drawable: Int, imageView: ImageView){
        Glide.with(context)
            .load(drawable)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25)))
            .into(imageView)
    }

}