package com.yonder.mji.uicomponent.meditationview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.yonder.mji.databinding.ViewMeditationsBinding
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel
import com.yonder.mji.uicomponent.meditationview.adapter.MtMeditationAdapter


class MTMeditationsView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  private val binding: ViewMeditationsBinding by lazy {
    ViewMeditationsBinding.inflate(LayoutInflater.from(context), this, true)
  }

  private val adapter: MtMeditationAdapter by lazy {
    MtMeditationAdapter()
  }

  fun initView(meditationList: List<MeditationUIModel>) = with(binding) {
    recyclerView.adapter = adapter.apply {
      submitList(meditationList)
    }
  }

}
