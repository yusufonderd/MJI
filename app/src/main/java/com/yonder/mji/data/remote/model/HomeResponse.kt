package com.yonder.mji.data.remote.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
  @SerializedName("isBannerEnabled") val isBannerEnabled: Boolean?,
  @SerializedName("meditations") val meditations: List<MeditationResponse>?,
  @SerializedName("stories") val stories: List<StoryResponse>?

)