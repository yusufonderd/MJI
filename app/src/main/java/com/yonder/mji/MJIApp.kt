package com.yonder.mji

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MJIApp : Application() {

  override fun onCreate() {
    super.onCreate()
    setUpTimber()
  }

  private fun setUpTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}
