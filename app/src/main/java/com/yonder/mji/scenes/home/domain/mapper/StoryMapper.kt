package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.data.remote.model.StoryResponse
import com.yonder.mji.scenes.home.domain.model.StoryUIModel
import javax.inject.Inject

class StoryMapper @Inject constructor(
  var imageMapper: ImageMapper
) : BaseMapper<StoryResponse, StoryUIModel> {
  override fun map(input: StoryResponse): StoryUIModel {
    return StoryUIModel(
      name = input.name.orEmpty(),
      category = input.category.orEmpty(),
      image = imageMapper.map(input = input.image)
    )
  }
}