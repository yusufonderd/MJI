package com.yonder.mji.scenes.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val DEFAULT_SOUND_URL = "https://d2r0ihkco3hemf.cloudfront.net/bgxupraW2spUpr_y2.mp3"

@HiltViewModel
class HomeDetailViewModel @Inject constructor() : ViewModel() {

  fun playSound(url : String = DEFAULT_SOUND_URL){

  }

}
