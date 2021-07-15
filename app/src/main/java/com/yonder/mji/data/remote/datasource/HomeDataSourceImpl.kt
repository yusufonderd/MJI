package com.yonder.mji.data.remote.datasource

import com.yonder.mji.data.remote.model.HomeResponse
import com.yonder.mji.data.remote.service.ApiService
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(
  private val service: ApiService
) : HomeDataSource {
  override suspend fun fetchHome(): HomeResponse {
    return service.fetchHome()
  }
}
