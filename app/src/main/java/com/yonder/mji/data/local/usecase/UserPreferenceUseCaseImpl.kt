package com.yonder.mji.data.local.usecase

import com.yonder.mji.data.local.prefs.LocalStorage
import com.yonder.mji.data.local.prefs.LocalStorageConstants
import javax.inject.Inject

class UserPreferenceUseCaseImpl @Inject constructor(
  private val localStorage: LocalStorage
) : UserPreferenceUseCase {

  override fun getUsername(): String {
    return localStorage.getString(LocalStorageConstants.KEY_USERNAME).orEmpty()
  }

  override fun saveUsername(username: String) {
    localStorage.setString(LocalStorageConstants.KEY_USERNAME, username)
  }
}