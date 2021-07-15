package com.yonder.mji.uicomponent

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView
import com.yonder.mji.databinding.ViewHeaderBinding


class MTHeaderView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

  private val binding: ViewHeaderBinding by lazy {
    ViewHeaderBinding.inflate(LayoutInflater.from(context), this, true)
  }

  fun initView(
    @DrawableRes imageResId: Int,
    @StringRes textResId: Int
  ) {
    binding.tvHeader.setText(textResId)
    binding.ivHeader.setImageDrawable(ContextCompat.getDrawable(context,imageResId))
  }
}
