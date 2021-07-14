package com.yonder.mji.core.base

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

  private var _binding: VB? = null
  val binding get() = _binding!!


  open fun setupUI() {

  }

  open fun observeData() {

  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = inflate.invoke(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupUI()
    observeData()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  fun closeFragment() {
    findNavController().popBackStack()
  }

  fun showToast(@StringRes messageResId: Int) {
    Toast.makeText(context, getString(messageResId), Toast.LENGTH_SHORT).show()
  }
}