package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.data.remote.model.ImageResponse
import com.yonder.mji.scenes.home.domain.model.ImageUIModel
import javax.inject.Inject

class ImageMapper @Inject constructor() : BaseMapper<ImageResponse?, ImageUIModel> {
  override fun map(input: ImageResponse?): ImageUIModel {
    return ImageUIModel(small = input?.small.orEmpty(), large = input?.large.orEmpty())
  }
}