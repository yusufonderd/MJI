package com.yonder.mji.data.local.prefs

interface LocalStorage {
  fun setString(key: String, value: String)
  fun getString(key: String): String?
}

