package com.yonder.mji.data.remote.datasource

import com.yonder.mji.data.remote.model.HomeResponse


interface HomeDataSource {
  suspend fun fetchHome(): HomeResponse
}

