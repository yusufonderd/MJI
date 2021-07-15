package com.yonder.mji.scenes.home.domain.mapper

import com.yonder.mji.scenes.home.domain.model.HomeDetailArgData
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel
import com.yonder.mji.scenes.home.domain.model.StoryUIModel

object HomeDetailMapper {

  fun mapWithStory(input: StoryUIModel): HomeDetailArgData {
    return HomeDetailArgData(
      image = input.image,
      title = input.name,
      text = input.text,
      date = input.date
    )
  }

  fun mapWithMeditation(input: MeditationUIModel): HomeDetailArgData {
    return HomeDetailArgData(
      image = input.image,
      title = input.title,
      text = input.content,
      date = input.date
    )
  }

}