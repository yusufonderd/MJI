package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.data.remote.model.ImageResponse
import org.junit.Test

class ImageMapperTest {

  val imageMapper = ImageMapper()

  @Test
  fun `given image response, when map, then matches correct model`() {
    //given
    val largeImageUrl = "largeImage"
    val smallImageUrl = "smallImage"
    val response = ImageResponse(smallImageUrl, largeImageUrl)

    //when
    val imageUIModel = imageMapper.map(response)

    //then
    assert(imageUIModel.large == largeImageUrl)
    assert(imageUIModel.small == smallImageUrl)

  }


}