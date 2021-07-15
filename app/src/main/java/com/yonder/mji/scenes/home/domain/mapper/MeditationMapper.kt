package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.data.remote.model.MeditationResponse
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel
import javax.inject.Inject

class MeditationMapper @Inject constructor(
  var imageMapper: ImageMapper
) : BaseMapper<MeditationResponse, MeditationUIModel> {
  override fun map(input: MeditationResponse): MeditationUIModel {
    return MeditationUIModel(
      title = input.title.orEmpty(),
      subTitle = input.subtitle.orEmpty(),
      image = imageMapper.map(input = input.image!!)
    )
  }
}