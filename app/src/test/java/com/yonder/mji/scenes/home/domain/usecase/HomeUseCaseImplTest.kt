package com.yonder.mji.scenes.home.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yonder.mji.core.data.State
import com.yonder.mji.data.remote.model.HomeResponse
import com.yonder.mji.data.remote.repository.HomeRepository
import com.yonder.mji.scenes.home.domain.mapper.HomeMapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeUseCaseImplTest {

  //Executes each task synchronously.
  @get:Rule
  var instantExecutorRule = InstantTaskExecutorRule()

  @MockK
  private lateinit var homeRepository: HomeRepository

  @MockK
  private lateinit var homeMapper: HomeMapper

  lateinit var homeUseCaseImpl: HomeUseCaseImpl

  @Before
  fun setUp() {
    MockKAnnotations.init(this, relaxed = true)
    homeUseCaseImpl = HomeUseCaseImpl(
      homeRepository,
      homeMapper
    )
  }

  @Test
  fun `when fetchHome is called, then last state is success`() =
    runBlocking {
      //given
      val termResponse = HomeResponse(true, emptyList(), emptyList())

      coEvery {
        homeRepository.fetchHome()
      } returns flow {
        emit(State.Loading)
        emit(State.Success(termResponse))
      }

      //when
      val result = homeUseCaseImpl.fetchHome().toList()

      //then
      assert(result[0] is State.Loading)
      assert(result[1] is State.Success)
    }

  @Test
  fun `when fetchHome is called, then last state is error`() =
    runBlocking {
      //given
      val exception = Throwable("error")

      coEvery {
        homeRepository.fetchHome()
      } returns flow {
        emit(State.Loading)
        emit(State.Error(exception))
      }

      //when
      val result = homeUseCaseImpl.fetchHome().toList()

      //then
      assert(result[0] is State.Loading)
      assert(result[1] is State.Error)
    }

}