package com.yonder.mji.common.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class MtMediaPlayerImpl @Inject constructor(@ApplicationContext private val context: Context) :
  MtMediaPlayer {
  private val player: MediaPlayer = MediaPlayer()

  override fun toggle(url: String) {
    try {
      if (player.isPlaying.not()) {
        play(url)
      } else {
        stop()
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  override fun isPlaying(): Boolean {
    return player.isPlaying
  }

  override fun play(url: String) {
    val uri: Uri = Uri.parse(url)
    player.setDataSource(context, uri)
    player.prepare()
    player.start()
  }

  override fun stop() {
    player.stop();
    player.reset()
  }

}