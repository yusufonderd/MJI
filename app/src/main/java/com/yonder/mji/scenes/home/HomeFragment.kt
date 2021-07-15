package com.yonder.mji.scenes.home

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yonder.mji.R
import com.yonder.mji.core.base.BaseFragment
import com.yonder.mji.core.utils.decider.StringFormatDecider
import com.yonder.mji.databinding.FragmentHomeBinding
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
import com.yonder.mji.scenes.home.domain.model.StoryUIModel
import com.yonder.statelayout.State
import com.yonder.statelayout.StateLayoutListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

  @Inject
  lateinit var stringFormatDecider: StringFormatDecider

  private val viewModel: HomeViewModel by viewModels()

  override fun initUI() {
    binding.stateLayoutView.setOnTryAgainClickListener(object :
      StateLayoutListener.TryAgainClickListener {
      override fun onClickTryAgain() {
        viewModel.fetchHome()
      }
    })
  }

  override fun observeData() {
    collectViewState()
  }

  private fun collectViewState() {
    lifecycleScope.launchWhenCreated {
      viewModel.state.collect { viewState ->
        when (viewState) {
          is HomeViewState.Load -> {
            loadViewState(viewState.homeUIModel, viewState.username)
          }
          is HomeViewState.ShowLoading -> {
            showLoading()
          }
          is HomeViewState.ShowError -> {
            showError(viewState.message)
          }
        }
      }
    }
  }

  private fun showError(message: String) {
    showToast(message)
    binding.stateLayoutView.setState(State.ERROR)
  }

  private fun showLoading() {
    binding.stateLayoutView.setState(State.LOADING)
  }

  private fun loadViewState(homeUIModel: HomeUIModel, username: String) = with(binding) {
    binding.stateLayoutView.setState(State.CONTENT)
    mtMeditationView.initView(homeUIModel.meditations)
    mtHeaderView.isVisible = homeUIModel.isBannerEnabled
    mtHeaderView.initView(
      R.drawable.ic_night,
      stringFormatDecider.format(R.string.title_view_header, username)
    )
    mtStoriesView.initView(homeUIModel.stories) { story ->
      navigateToDetail(story)
    }
  }

  private fun navigateToDetail(story: StoryUIModel) {
    findNavController().navigate(HomeFragmentDirections.actionHomeDetail(story))
  }
}
