package com.yonder.mji.data.remote.model

import com.google.gson.annotations.SerializedName

data class MeditationResponse(
  @SerializedName("title") val title: String?,
  @SerializedName("subtitle") val subtitle: String?,
  @SerializedName("releaseDate") val releaseDate: String?,
  @SerializedName("content") val content: String?,
  @SerializedName("image") val image: ImageResponse?
)