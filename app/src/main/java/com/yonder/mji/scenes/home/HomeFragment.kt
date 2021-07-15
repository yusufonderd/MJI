package com.yonder.mji.scenes.home

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yonder.mji.R
import com.yonder.mji.core.base.BaseFragment
import com.yonder.mji.databinding.FragmentHomeBinding
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

  private val viewModel: HomeViewModel by viewModels()

  override fun observeData() {
    lifecycleScope.launchWhenCreated {
      viewModel.state.collect { viewState ->
        when (viewState) {
          is HomeViewState.Load -> {
            setHomeUIModel(viewState.homeUIModel)
          }
          is HomeViewState.ShowLoading -> {

          }
          is HomeViewState.ShowError -> {
            showToast(viewState.message)
          }
        }

      }
    }
  }

  private fun setHomeUIModel(homeUIModel: HomeUIModel) = with(binding) {
    mtMeditationView.initView(homeUIModel.meditations)
    mtHeaderView.isVisible = homeUIModel.isBannerEnabled
    mtHeaderView.initView(R.drawable.ic_night,R.string.title_view_header)
    mtStoriesView.initView(homeUIModel.stories)
  }
}
