package com.yonder.mji.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
  private val inflate: Inflate<VB>
) : Fragment() {

  internal var safeBinding: VB? = null
  val binding get() = safeBinding!!

  open fun initVariables(){}
  open fun initUI() {}
  open fun observeData() {}

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    safeBinding = inflate.invoke(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initVariables()
    initUI()
    observeData()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    safeBinding = null
  }

  fun closeFragment() {
    findNavController().popBackStack()
  }

  fun showToast(@StringRes messageResId: Int) {
    showToast(getString(messageResId))
  }

  fun showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
  }
}