package com.yonder.mji.scenes.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yonder.mji.MainCoroutineRule
import com.yonder.mji.core.data.State
import com.yonder.mji.data.local.usecase.UserPreferenceUseCase
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
import com.yonder.mji.scenes.home.domain.usecase.HomeUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

  // Executes each task synchronously.
  @get:Rule
  val instantTaskExecutorRule = InstantTaskExecutorRule()

  @get:Rule
  var coroutinesTestRule = MainCoroutineRule()

  lateinit var homeViewModel: HomeViewModel

  @MockK
  lateinit var homeUseCase: HomeUseCase

  @MockK
  lateinit var userPreferenceUseCase: UserPreferenceUseCase

  @Before
  fun setUp() {
    MockKAnnotations.init(this, relaxed = true)
    homeViewModel = HomeViewModel(homeUseCase, userPreferenceUseCase)
  }

  @Test
  fun `when viewModel is initialized, state value set to loading`() =
    assert(homeViewModel.state.value == HomeViewState.ShowLoading)

  @Test
  fun `when given exception, when fetched home, returns error`() {
    //given
    val exceptionMessage = "Connection problem"
    val exception = Throwable(exceptionMessage)

    val res = MutableStateFlow(State.Error(exception))

    coEvery {
      homeUseCase.fetchHome()
    } returns res

    //when
    homeViewModel.fetchHome()

    //then
    assert((homeViewModel.state.value as HomeViewState.ShowError).message == exceptionMessage)
  }

  @Test
  fun `when fetched home, returns success`() {
    //given
    val homeUIModel = mockk<HomeUIModel>()
    val res = MutableStateFlow(State.Success(homeUIModel))
    coEvery {
      homeUseCase.fetchHome()
    } returns res

    //when
    homeViewModel.fetchHome()

    //then
    assert((homeViewModel.state.value as HomeViewState.Load).homeUIModel == homeUIModel)
  }

}