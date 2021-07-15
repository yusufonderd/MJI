package com.yonder.mji.common.mediaplayer

interface MtMediaPlayer {
  fun toggle(url: String)
  fun play(url: String)
  fun stop()
  fun isPlaying(): Boolean
  fun registerStateListener(stateListener: MtMediaPlayerStateListener)
  fun unregisterStateListener()

  interface MtMediaPlayerStateListener {
    fun onStarted()
    fun onInitialized()
    fun onStopped()
    fun onError(message: String)
  }
}