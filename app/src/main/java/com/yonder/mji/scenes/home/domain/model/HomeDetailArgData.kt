package com.yonder.mji.scenes.home.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeDetailArgData(
  var image: ImageUIModel,
  var title: String,
  var text: String,
  var date : String
):Parcelable