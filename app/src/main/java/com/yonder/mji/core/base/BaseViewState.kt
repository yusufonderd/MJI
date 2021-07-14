package com.yonder.mji.core.base

import androidx.annotation.StringRes


sealed class BaseViewState {
  object Initial : BaseViewState()
  object Loading : BaseViewState()
  data class Error(@StringRes var messageResId: Int) : BaseViewState()
  object Success : BaseViewState()
}