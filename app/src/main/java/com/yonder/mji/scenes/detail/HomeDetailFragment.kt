package com.yonder.mji.scenes.detail

import androidx.navigation.fragment.navArgs
import com.yonder.mji.R
import com.yonder.mji.common.mediaplayer.MtMediaPlayer
import com.yonder.mji.core.base.BaseFragment
import com.yonder.mji.core.extensions.setSafeOnClickListener
import com.yonder.mji.data.remote.service.Endpoints
import com.yonder.mji.databinding.FragmentHomeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeDetailFragment :
  BaseFragment<FragmentHomeDetailBinding>(FragmentHomeDetailBinding::inflate) {

  @Inject
  lateinit var mediaPlayer: MtMediaPlayer

  private val args: HomeDetailFragmentArgs by navArgs()

  private val story get() = args.detail

  override fun initUI() = with(binding) {
    tvTitle.text = story.title
    tvText.text = story.text
    tvDate.text = story.date
    btnToggleSound.setSafeOnClickListener {
      mediaPlayer.toggle(Endpoints.DEFAULT_SOUND_URL)
      setToggleButtonImage()
    }
  }

  override fun onResume() {
    super.onResume()
    setToggleButtonImage()
  }

  private fun setToggleButtonImage() {
    if (mediaPlayer.isPlaying().not()) {
      binding.btnToggleSound.setImageResource(R.drawable.ic_baseline_play_arrow_36)
    } else {
      binding.btnToggleSound.setImageResource(R.drawable.ic_baseline_stop_36)
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    mediaPlayer.stop()
  }

}
