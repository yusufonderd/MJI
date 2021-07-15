package com.yonder.mji.data.remote.model

import com.google.gson.annotations.SerializedName

data class ImageResponse(
  @SerializedName("small") val small: String?,
  @SerializedName("large") val large: String?
)