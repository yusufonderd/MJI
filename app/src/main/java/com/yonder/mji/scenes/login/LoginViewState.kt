package com.yonder.mji.scenes.login

import androidx.annotation.StringRes


sealed class LoginViewState {
  object NavigateHomeScreen : LoginViewState()
  data class ShowError(@StringRes val messageResId: Int) : LoginViewState()

  override fun equals(other: Any?): Boolean {
    return false
  }
  override fun hashCode(): Int {
    return javaClass.hashCode()
  }
}