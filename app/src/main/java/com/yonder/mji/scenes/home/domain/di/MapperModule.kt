package com.yonder.mji.scenes.home.domain.di

import com.yonder.mji.core.mapper.BaseMapper
import com.yonder.mji.data.remote.model.HomeResponse
import com.yonder.mji.data.remote.model.MeditationResponse
import com.yonder.mji.data.remote.model.StoryResponse
import com.yonder.mji.scenes.home.domain.mapper.HomeMapper
import com.yonder.mji.scenes.home.domain.mapper.MeditationMapper
import com.yonder.mji.scenes.home.domain.mapper.StoryMapper
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
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
  ): BaseMapper<StoryResponse, StoryUIModel> {
    return StoryMapper()
  }

  @Provides
  fun provideMeditationMapper(
  ): BaseMapper<MeditationResponse, MeditationUIModel> {
    return MeditationMapper()
  }

  @Provides
  fun provideHomeMapper(
    meditationMapper: MeditationMapper,
    storyMapper: StoryMapper
  ): BaseMapper<HomeResponse, HomeUIModel> {
    return HomeMapper(meditationMapper, storyMapper)
  }

}