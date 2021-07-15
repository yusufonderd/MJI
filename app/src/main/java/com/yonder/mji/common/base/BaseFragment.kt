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

  private var safeBinding: VB? = null
  val binding get() = safeBinding!!

  open fun initVariables(){}
  open fun initUI() {}
  open fun observeData() {}

  var fragmentView: View? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
   return  if (fragmentView == null){
      safeBinding = inflate.invoke(inflater, container, false)
      return binding.root.also {
        fragmentView = it
      }
    }else fragmentView

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initVariables()
    initUI()
    observeData()
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