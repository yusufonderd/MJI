package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.core.utils.decider.DateFormatDecider
import com.yonder.mji.data.remote.model.StoryResponse
import com.yonder.mji.scenes.home.domain.model.StoryUIModel
import javax.inject.Inject

class StoryMapper @Inject constructor(
  val imageMapper: ImageMapper,
  private val dateFormatDecider: DateFormatDecider
) : BaseMapper<StoryResponse, StoryUIModel> {
  override fun map(input: StoryResponse): StoryUIModel {
    return StoryUIModel(
      name = input.name.orEmpty(),
      date = dateFormatDecider.formatEpochTime(input.date),
      category = input.category.orEmpty(),
      text = input.text.orEmpty(),
      image = imageMapper.map(input = input.image)
    )
  }
}