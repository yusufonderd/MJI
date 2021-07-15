package com.yonder.mji.scenes.detail

import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.yonder.mji.R
import com.yonder.mji.common.mediaplayer.MtMediaPlayer
import com.yonder.mji.common.base.BaseFragment
import com.yonder.mji.common.extensions.setSafeOnClickListener
import com.yonder.mji.data.remote.service.Endpoints
import com.yonder.mji.databinding.FragmentMediaDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MediaDetailFragment :
  BaseFragment<FragmentMediaDetailBinding>(FragmentMediaDetailBinding::inflate) {

  @Inject
  lateinit var mediaPlayer: MtMediaPlayer

  private val args: MediaDetailFragmentArgs by navArgs()

  private val story get() = args.detail

  override fun initUI() = with(binding) {
    tvTitle.text = story.title
    tvText.text = story.text
    tvDate.text = story.date
    btnToggleSound.setSafeOnClickListener {
      mediaPlayer.toggle(Endpoints.DEFAULT_SOUND_URL)
    }
    setMediaPlayerStateListener()
  }

  private fun setMediaPlayerStateListener() {
    mediaPlayer.registerStateListener(object : MtMediaPlayer.MtMediaPlayerStateListener {
      override fun onError(message: String) {
        hideProgress()
        showToast(message)
      }

      override fun onInitialized() {
        showProgress()
      }

      override fun onStarted() {
        binding.btnToggleSound.setImageResource(R.drawable.ic_baseline_stop_36)
        hideProgress()
      }

      override fun onStopped() {
        hideProgress()
        binding.btnToggleSound.setImageResource(R.drawable.ic_baseline_play_arrow_36)
      }
    })
  }


  override fun onResume() {
    super.onResume()
    setToggleButtonImage()
  }

  private fun setToggleButtonImage() {
    if (mediaPlayer.isPlaying()) {
      binding.btnToggleSound.setImageResource(R.drawable.ic_baseline_stop_36)
    } else {
      binding.btnToggleSound.setImageResource(R.drawable.ic_baseline_play_arrow_36)
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    mediaPlayer.unregisterStateListener()
    mediaPlayer.stop()
  }


  private fun hideProgress() {
    binding.pbLoading.isVisible = false
  }

  private fun showProgress() {
    binding.pbLoading.isVisible = true
  }


}
