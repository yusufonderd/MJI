package com.yonder.mji.data.remote.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yonder.mji.MainCoroutineRule
import com.yonder.mji.core.data.State
import com.yonder.mji.data.remote.datasource.HomeDataSource
import com.yonder.mji.data.remote.model.HomeResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class HomeRepositoryImplTest {

  // Executes each task synchronously.
  @get:Rule
  var instantExecutorRule = InstantTaskExecutorRule()

  @get:Rule
  var mainCoroutineRule =  MainCoroutineRule()

  lateinit var homeRepositoryImpl : HomeRepositoryImpl

  @MockK
  private lateinit var homeDataSource: HomeDataSource

  @Before
  fun setUp() {
    MockKAnnotations.init(this, relaxed = true)
    homeRepositoryImpl = HomeRepositoryImpl(
      homeDataSource
    )
  }

  @Test
  fun `when fetchHome is called, returns success`() = runBlocking {
    val response = mockk<HomeResponse>()

    coEvery {
      homeDataSource.fetchHome()
    } returns response

    //when
    val result = homeRepositoryImpl.fetchHome()
      .toList()

    //then
    assert(result[0] == State.Loading)
    assert((result[1] as State.Success).data == response)
  }





}