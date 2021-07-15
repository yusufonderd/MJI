package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.data.remote.model.MeditationResponse
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel
import javax.inject.Inject

class MeditationMapper @Inject constructor() : BaseMapper<MeditationResponse, MeditationUIModel> {
  override fun map(input: MeditationResponse): MeditationUIModel {
    return MeditationUIModel(input.title.orEmpty())
  }
}