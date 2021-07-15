package com.yonder.mji.uicomponent

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.yonder.mji.databinding.ViewStoriesBinding


class MtStoriesView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  private val binding: ViewStoriesBinding by lazy {
    ViewStoriesBinding.inflate(LayoutInflater.from(context), this, true)
  }

}
