package com.yonder.mji.scenes.home.domain.usecase

import com.yonder.mji.core.data.State
import com.yonder.mji.core.data.map
import com.yonder.mji.data.remote.repository.HomeRepository
import com.yonder.mji.scenes.home.domain.mapper.HomeMapper
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
  var repository: HomeRepository,
  var homeMapper: HomeMapper
) : HomeUseCase {
  override fun fetchHome(): Flow<State<HomeUIModel>> =
    repository.fetchHome().map { state ->
      state.map { input ->
        homeMapper.map(input)
      }
    }
}