package com.yonder.mji.data.local.prefs

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class LocalStorageImpl @Inject constructor(
  @ApplicationContext context: Context
) : LocalStorage {

  private val sharedPreferences = context.getSharedPreferences(
    "MJI",
    Context.MODE_PRIVATE
  )

  override fun setString(key: String, value: String) {
    with(sharedPreferences.edit()) {
      putString(key, value)
      apply()
    }

  }

  override fun getString(key: String): String? {
    return sharedPreferences.getString(key, null)
  }

}
