package com.yonder.mji.scenes.home

import androidx.fragment.app.viewModels
import com.yonder.mji.core.base.BaseFragment
import com.yonder.mji.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

  private val viewModel: HomeViewModel by viewModels()

}
