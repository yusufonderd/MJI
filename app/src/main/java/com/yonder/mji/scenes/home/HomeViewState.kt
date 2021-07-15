package com.yonder.mji.scenes.home

import com.yonder.mji.scenes.home.domain.model.HomeUIModel

sealed class HomeViewState {
  object ShowLoading : HomeViewState()
  data class Load(val homeUIModel: HomeUIModel) : HomeViewState()
  data class ShowError(val message: String) : HomeViewState()
}