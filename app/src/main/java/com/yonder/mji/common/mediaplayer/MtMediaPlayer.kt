package com.yonder.mji.common.mediaplayer

interface MtMediaPlayer {
  fun toggle(url: String)
  fun play(url: String)
  fun stop()
  fun isPlaying(): Boolean
}