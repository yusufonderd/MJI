package com.yonder.mji.uicomponent.headerview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.yonder.mji.databinding.ViewHeaderBinding

class MTHeaderView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

  private val binding: ViewHeaderBinding by lazy {
    ViewHeaderBinding.inflate(LayoutInflater.from(context), this, true)
  }

  fun initView(
    @DrawableRes imageResId: Int,
    text: String
  ) {
    binding.tvHeader.text = text
    binding.ivHeader.setImageDrawable(ContextCompat.getDrawable(context, imageResId))
  }
}
