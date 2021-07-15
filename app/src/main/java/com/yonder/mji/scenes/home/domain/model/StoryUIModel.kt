package com.yonder.mji.scenes.home.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoryUIModel(
  val name: String,
  val text: String,
  val category: String,
  val date : String,
  val image: ImageUIModel
): Parcelable
