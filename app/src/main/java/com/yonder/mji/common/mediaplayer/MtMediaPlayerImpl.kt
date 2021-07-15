package com.yonder.mji.common.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import com.yonder.mji.core.extensions.humanReadableMessage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MtMediaPlayerImpl @Inject constructor(@ApplicationContext private val context: Context) :
  MtMediaPlayer {
  private val player: MediaPlayer = MediaPlayer()

  var listener: MtMediaPlayer.MtMediaPlayerStateListener? = null

  override fun toggle(url: String) {
    if (isPlaying().not()) {
      play(url)
    } else {
      stop()
    }
  }

  override fun isPlaying(): Boolean {
    return player.isPlaying
  }

  private fun play(url: String) {
    try {
      listener?.onInitialized()
      val uri: Uri = Uri.parse(url)
      player.setDataSource(context, uri)
      player.prepareAsync()
    } catch (e: Exception) {
      listener?.onError(e.humanReadableMessage)
      e.printStackTrace()
    }
    player.setOnPreparedListener {
      player.start()
      listener?.onStarted()
    }
  }

  override fun stop() {
    player.stop();
    player.reset()
    listener?.onStopped()
  }

  override fun registerStateListener(stateListener: MtMediaPlayer.MtMediaPlayerStateListener) {
    listener = stateListener
  }

  override fun unregisterStateListener() {
    listener = null
  }

}