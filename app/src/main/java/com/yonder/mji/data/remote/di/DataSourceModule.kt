package com.yonder.mji.data.remote.di

import com.yonder.mji.data.remote.datasource.HomeDataSource
import com.yonder.mji.data.remote.datasource.HomeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

  @Binds
  abstract fun bindDataSource(
    dataSourceImpl: HomeDataSourceImpl
  ): HomeDataSource
}

