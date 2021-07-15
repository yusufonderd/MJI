package com.yonder.mji.scenes.home.domain.di

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.core.utils.decider.DateFormatDecider
import com.yonder.mji.data.remote.model.HomeResponse
import com.yonder.mji.data.remote.model.ImageResponse
import com.yonder.mji.data.remote.model.MeditationResponse
import com.yonder.mji.data.remote.model.StoryResponse
import com.yonder.mji.scenes.home.domain.mapper.HomeMapper
import com.yonder.mji.scenes.home.domain.mapper.ImageMapper
import com.yonder.mji.scenes.home.domain.mapper.MeditationMapper
import com.yonder.mji.scenes.home.domain.mapper.StoryMapper
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
import com.yonder.mji.scenes.home.domain.model.ImageUIModel
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel
import com.yonder.mji.scenes.home.domain.model.StoryUIModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

  @Provides
  fun provideStoryMapper(
    imageMapper: ImageMapper,
    dateFormatDecider: DateFormatDecider
  ): BaseMapper<StoryResponse, StoryUIModel> {
    return StoryMapper(imageMapper, dateFormatDecider)
  }

  @Provides
  fun provideImageMapper(
  ): BaseMapper<ImageResponse?, ImageUIModel> {
    return ImageMapper()
  }

  @Provides
  fun provideMeditationMapper(
    imageMapper: ImageMapper,
    dateFormatDecider: DateFormatDecider
  ): BaseMapper<MeditationResponse, MeditationUIModel> {
    return MeditationMapper(imageMapper,dateFormatDecider)
  }

  @Provides
  fun provideHomeMapper(
    meditationMapper: MeditationMapper,
    storyMapper: StoryMapper
  ): BaseMapper<HomeResponse, HomeUIModel> {
    return HomeMapper(meditationMapper, storyMapper)
  }

}