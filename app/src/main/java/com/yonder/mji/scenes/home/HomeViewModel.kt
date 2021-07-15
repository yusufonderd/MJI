package com.yonder.mji.scenes.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonder.mji.core.data.State
import com.yonder.mji.core.extensions.humanReadableMessage
import com.yonder.mji.data.remote.service.ApiEndpoints
import com.yonder.mji.scenes.home.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val useCase: HomeUseCase) : ViewModel() {

  private val _state = MutableStateFlow<HomeViewState>(HomeViewState.ShowLoading)
  val state: StateFlow<HomeViewState> = _state

  init {
    fetchHome()
  }

  private fun fetchHome() {
    viewModelScope.launch {
      useCase.fetchHome().collect { result ->
        _state.value = when (result) {
          is State.Loading -> HomeViewState.ShowLoading
          is State.Success -> HomeViewState.Load(result.data)
          is State.Error -> HomeViewState.ShowError(message = result.exception.humanReadableMessage)
        }
      }
    }
  }

}