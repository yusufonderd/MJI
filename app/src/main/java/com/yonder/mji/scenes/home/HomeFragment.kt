package com.yonder.mji.scenes.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yonder.mji.core.base.BaseFragment
import com.yonder.mji.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

  private val viewModel: HomeViewModel by viewModels()

  override fun observeData() {
    lifecycleScope.launchWhenCreated {
      viewModel.state.collect { viewState ->
        when(viewState){
          is HomeViewState.Load -> {

          }
          is HomeViewState.ShowLoading -> {

          }
          is HomeViewState.ShowError->{
            showToast(viewState.message)
          }
        }

      }
    }
  }
}
