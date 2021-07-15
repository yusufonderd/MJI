package com.yonder.mji.data.remote.di

import com.yonder.mji.data.remote.repository.HomeRepository
import com.yonder.mji.data.remote.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

  @Binds
  abstract fun bindHomeRepository(
    repositoryImpl: HomeRepositoryImpl
  ): HomeRepository
}


