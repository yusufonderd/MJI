package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.data.remote.model.StoryResponse
import com.yonder.mji.scenes.home.domain.model.StoryUIModel
import javax.inject.Inject

class StoryMapper @Inject constructor() : BaseMapper<StoryResponse, StoryUIModel> {
  override fun map(input: StoryResponse): StoryUIModel {
    return StoryUIModel(input.name.orEmpty())
  }
}