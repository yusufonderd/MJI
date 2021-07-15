package com.yonder.mji.data.remote.service

import com.yonder.mji.data.remote.model.HomeResponse
import retrofit2.http.GET


interface ApiService {

  @GET(ApiEndpoints.HOME_PATH)
  suspend fun fetchHome(): HomeResponse

}