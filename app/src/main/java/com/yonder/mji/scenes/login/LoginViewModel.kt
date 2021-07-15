package com.yonder.mji.scenes.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yonder.mji.data.local.usecase.UserPreferenceUseCase
import com.yonder.mji.common.utils.CredentialsValidator
import com.yonder.mji.common.utils.CredentialsValidatorResultListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val userPreferenceUseCase: UserPreferenceUseCase
) : ViewModel() {

  private val _state = MutableLiveData<LoginViewState>()
  val state: LiveData<LoginViewState> = _state

  fun makeLogin(username: String, password: String) {
    val validator = CredentialsValidator(object : CredentialsValidatorResultListener {
      override fun onSuccess() {
        saveUsername(username)
        _state.value = LoginViewState.NavigateHomeScreen
      }

      override fun onError(messageResId: Int) {
        _state.value = LoginViewState.ShowError(messageResId)
      }
    })
    validator.validate(username, password)

  }
  private fun saveUsername(username: String){
    userPreferenceUseCase.saveUsername(username)
  }
}