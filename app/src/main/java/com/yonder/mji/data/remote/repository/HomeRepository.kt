package com.yonder.mji.data.remote.repository

import com.yonder.mji.core.data.State
import com.yonder.mji.data.remote.model.HomeResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
  fun fetchHome(): Flow<State<HomeResponse>>
}