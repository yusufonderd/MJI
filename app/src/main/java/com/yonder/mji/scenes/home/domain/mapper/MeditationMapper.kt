package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.core.utils.decider.DateFormatDecider
import com.yonder.mji.data.remote.model.MeditationResponse
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel
import javax.inject.Inject

class MeditationMapper @Inject constructor(
  private val imageMapper: ImageMapper,
  private val dateFormatDecider: DateFormatDecider
) : BaseMapper<MeditationResponse, MeditationUIModel> {
  override fun map(input: MeditationResponse): MeditationUIModel {
    return MeditationUIModel(
      title = input.title.orEmpty(),
      subTitle = input.subtitle.orEmpty(),
      content = input.content.orEmpty(),
      date = dateFormatDecider.formatEpochTime(input.releaseDate),
      image = imageMapper.map(input = input.image)
    )
  }
}