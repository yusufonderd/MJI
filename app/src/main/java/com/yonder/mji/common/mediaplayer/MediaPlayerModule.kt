package com.yonder.mji.common.mediaplayer

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MediaPlayerModule {

  @Singleton
  @Provides
  fun provideMediaPlayer(@ApplicationContext context: Context): MtMediaPlayer {
    return MtMediaPlayerImpl(context)
  }
}
