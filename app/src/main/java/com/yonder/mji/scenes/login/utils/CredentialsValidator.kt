package com.yonder.mji.scenes.login.utils

import androidx.annotation.StringRes
import com.yonder.mji.R
import com.yonder.mji.core.utils.RegexValidator


private const val PASSWORD_REGEX_PATTERN = "^(?=.*?[A-Z])(?=.*?[0-9]).{6,}$"
private const val USERNAME_VALIDATION_CHARACTER_LIMIT = 2

class CredentialsValidator(private val listener: CredentialsValidatorResultListener) {

  fun validate(username: String, password: String) {
    if (username.length <= USERNAME_VALIDATION_CHARACTER_LIMIT) {
      listener.onError(R.string.error_msg_username_not_valid)
    } else {
      if (RegexValidator(PASSWORD_REGEX_PATTERN).isValid(password)) {
        listener.onValid()
      } else {
        listener.onError(R.string.error_msg_password_not_valid)
      }
    }
  }
}

interface CredentialsValidatorResultListener {
  fun onValid()
  fun onError(@StringRes messageResId: Int)
}