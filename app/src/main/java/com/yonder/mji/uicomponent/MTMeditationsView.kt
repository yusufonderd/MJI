package com.yonder.mji.uicomponent

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.yonder.mji.databinding.ViewMeditationsBinding


class MTMeditationsView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  private val binding: ViewMeditationsBinding by lazy {
    ViewMeditationsBinding.inflate(LayoutInflater.from(context), this, true)
  }


}
