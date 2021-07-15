package com.yonder.mji.scenes.home.domain.model


data class HomeUIModel(
  val isBannerEnabled: Boolean,
  val meditations: List<MeditationUIModel>,
  val stories: List<StoryUIModel>
)