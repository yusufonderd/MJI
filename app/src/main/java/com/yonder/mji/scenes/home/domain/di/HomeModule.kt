package com.yonder.mji.scenes.home.domain.di

import com.yonder.mji.scenes.home.domain.usecase.HomeUseCase
import com.yonder.mji.scenes.home.domain.usecase.HomeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent



@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeModule {

  @Binds
  abstract fun bindHomeUseCase(
    homeUseCaseImpl: HomeUseCaseImpl
  ): HomeUseCase

}