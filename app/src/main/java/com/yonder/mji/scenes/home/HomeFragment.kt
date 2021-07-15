package com.yonder.mji.scenes.home

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yonder.mji.R
import com.yonder.mji.common.base.BaseFragment
import com.yonder.mji.common.utils.StringFormatDecider
import com.yonder.mji.databinding.FragmentHomeBinding
import com.yonder.mji.scenes.home.domain.mapper.HomeDetailMapper
import com.yonder.mji.scenes.home.domain.model.HomeDetailArgData
import com.yonder.mji.scenes.home.domain.model.HomeUIModel
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel
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
    binding.stateLayoutView.setState(State.ERROR)
  }

  private fun showLoading() {
    binding.stateLayoutView.setState(State.LOADING)
  }

  private fun loadViewState(homeUIModel: HomeUIModel, username: String) = with(binding) {
    binding.stateLayoutView.setState(State.CONTENT)
    initMeditations(homeUIModel.meditations)
    initStories(homeUIModel.stories)
    initHeader(homeUIModel.isBannerEnabled, username)
  }

  private fun initHeader(isBannerEnabled: Boolean, username: String) = with(binding.mtHeaderView) {
    isVisible = isBannerEnabled
    initView(
      R.drawable.ic_night,
      stringFormatDecider.format(R.string.title_view_header, username)
    )
  }

  private fun initStories(stories: List<StoryUIModel>) = with(binding.mtStoriesView) {
    onClickStory = { story ->
      navigateToDetail(data = HomeDetailMapper.mapWithStory(story))
    }
    initView(stories)
  }

  private fun initMeditations(meditations: List<MeditationUIModel>) =
    with(binding.mtMeditationView) {
      onClickMeditation = { meditation ->
        navigateToDetail(data = HomeDetailMapper.mapWithMeditation(meditation))
      }
      initView(meditations)
    }

  private fun navigateToDetail(data: HomeDetailArgData) {
    findNavController().navigate(HomeFragmentDirections.actionHomeDetail(data))
  }
}
