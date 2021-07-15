package com.yonder.mji.scenes.home.domain.usecase

import com.yonder.mji.core.data.State
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
  fun fetchHome(): Flow<State<HomeUIModel>>
}