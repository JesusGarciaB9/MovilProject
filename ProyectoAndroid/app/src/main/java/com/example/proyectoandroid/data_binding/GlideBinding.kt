package com.example.proyectoandroid.data_binding

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.proyectoandroid.R
import androidx.databinding.BindingAdapter

class GlideBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("imageResource")
        fun setImageResource(view: ImageView, imageUrl: Int) { //String

            val context = view.getContext()

            val option = RequestOptions()
                .placeholder(R.drawable.giphy)
                .error(R.drawable.giphy)

            Glide.with(context)
                .setDefaultRequestOptions(option)
                .load(imageUrl)
                .into(view)

        }

        @JvmStatic
        @BindingAdapter("imageResourceUrl")
        fun setImageResourceUrl(view: ImageView, imageUrl: String) { //String

            val context = view.getContext()

            val option = RequestOptions()
                .placeholder(R.drawable.giphy).dontAnimate()
                .error(R.drawable.giphy)

            Glide.with(context)
                .setDefaultRequestOptions(option)
                .load(imageUrl)
                .into(view)

        }
    }
}