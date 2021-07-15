package com.yonder.mji.data.remote.model

import com.google.gson.annotations.SerializedName

data class StoryResponse(
  @SerializedName("name") val name: String?,
  @SerializedName("category") val category: String?,
  @SerializedName("date") val date: String?,
  @SerializedName("text") val text: String?,
  @SerializedName("image") val image: ImageResponse?
)
