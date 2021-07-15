package com.yonder.mji.core.extensions

import android.widget.ImageView
import com.yonder.mji.data.remote.di.GlideApp

fun ImageView.setImageUrl(url: String) {
  GlideApp.with(context)
    .load(url)
    .into(this)
}
