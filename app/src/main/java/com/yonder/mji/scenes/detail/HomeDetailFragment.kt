package com.yonder.mji.scenes.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yonder.mji.core.base.BaseFragment
import com.yonder.mji.core.extensions.setSafeOnClickListener
import com.yonder.mji.databinding.FragmentHomeDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeDetailFragment :
  BaseFragment<FragmentHomeDetailBinding>(FragmentHomeDetailBinding::inflate) {

  private val viewModel: HomeDetailViewModel by viewModels()

  private val args: HomeDetailFragmentArgs by navArgs()

  private val story get() = args.story

  override fun initUI() = with(binding){
    tvTitle.text = story.name
    tvText.text = story.text
    tvDate.text = story.date
    btnToggleSound.setSafeOnClickListener {
      viewModel.playSound()
    }
  }
}
