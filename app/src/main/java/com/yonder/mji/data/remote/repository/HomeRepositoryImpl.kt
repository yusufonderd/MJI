package com.yonder.mji.data.remote.repository

import com.yonder.mji.core.data.BaseRepository
import com.yonder.mji.core.data.State
import com.yonder.mji.data.remote.datasource.HomeDataSource
import com.yonder.mji.data.remote.model.HomeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
  private val homeDataSource: HomeDataSource
) : BaseRepository(), HomeRepository {

  override fun fetchHome(): Flow<State<HomeResponse>> = apiCall(Dispatchers.IO) {
    homeDataSource.fetchHome()
  }
}

