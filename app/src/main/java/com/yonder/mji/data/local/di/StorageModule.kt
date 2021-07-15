package com.yonder.mji.data.local.di

import com.yonder.mji.data.local.prefs.LocalStorage
import com.yonder.mji.data.local.prefs.LocalStorageImpl
import com.yonder.mji.data.local.usecase.UserPreferenceUseCase
import com.yonder.mji.data.local.usecase.UserPreferenceUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class StorageModule {

  @Binds
  abstract fun provideStorage(storage: LocalStorageImpl): LocalStorage

  @Binds
  abstract fun bindPreferenceUseCase(
    preferenceCaseImpl: UserPreferenceUseCaseImpl
  ): UserPreferenceUseCase

}
