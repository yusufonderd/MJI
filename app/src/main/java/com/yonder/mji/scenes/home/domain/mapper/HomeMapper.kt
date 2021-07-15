package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.core.mapper.BaseListMapperImpl
import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.core.extensions.orFalse
import com.yonder.mji.data.remote.model.HomeResponse
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
import javax.inject.Inject

class HomeMapper @Inject constructor(
  private val meditationMapper: MeditationMapper,
  private val storyMapper: StoryMapper
) : BaseMapper<HomeResponse, HomeUIModel> {
  override fun map(input: HomeResponse): HomeUIModel {
    val stories = input.stories
      ?.filter { story -> story.image != null && story.text != null }
      .orEmpty()
    val meditations = input.meditations
      ?.filter { meditation -> meditation.image != null && meditation.title != null }
      .orEmpty()
    val storyUIModels = BaseListMapperImpl(storyMapper).map(stories)
    val meditationUIModels = BaseListMapperImpl(meditationMapper).map(meditations)
    return HomeUIModel(
      isBannerEnabled = input.isBannerEnabled.orFalse(),
      stories = storyUIModels,
      meditations = meditationUIModels
    )
  }
}