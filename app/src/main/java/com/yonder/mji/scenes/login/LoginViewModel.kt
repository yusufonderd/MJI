package com.yonder.mji.scenes.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yonder.mji.scenes.login.utils.CredentialsValidator
import com.yonder.mji.scenes.login.utils.CredentialsValidatorResultListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

  private val _state = MutableLiveData<LoginViewState>()
  val state: LiveData<LoginViewState> = _state

  fun makeLogin(username: String, password: String) {
    val validator = CredentialsValidator(object : CredentialsValidatorResultListener {
      override fun onSuccess() {
        _state.value = LoginViewState.NavigateHomeScreen
      }
      override fun onError(messageResId: Int) {
        _state.value = LoginViewState.ShowError(messageResId)
      }
    })
    validator.validate(username, password)

  }
}