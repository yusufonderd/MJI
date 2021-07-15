package com.yonder.mji.scenes.home.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageUIModel(
  val small: String,
  val large: String
):Parcelable
