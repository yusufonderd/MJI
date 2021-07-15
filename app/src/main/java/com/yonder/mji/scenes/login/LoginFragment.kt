package com.yonder.mji.scenes.login

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yonder.mji.common.base.BaseFragment
import com.yonder.mji.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

  private val viewModel: LoginViewModel by viewModels()

  override fun initUI() = with(binding) {
    btnLogin.setOnClickListener {
      viewModel.makeLogin(
        username = tfUsername.text.toString(),
        password = tfPassword.text.toString()
      )
    }
  }

  override fun observeData() {
    viewModel.state.observe(viewLifecycleOwner) { viewState ->
      when (viewState) {
        is LoginViewState.ShowError -> {
          showToast(viewState.messageResId)
        }
        is LoginViewState.NavigateHomeScreen -> {
          navigateToHomeScreen()
        }
        else -> Unit
      }
    }
  }

  private fun navigateToHomeScreen() {
    findNavController().navigate(LoginFragmentDirections.actionHome())
  }
}
