package com.yonder.mji.uicomponent.meditationview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yonder.mji.core.extensions.setUrl
import com.yonder.mji.databinding.ItemMtMeditationBinding
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel


class MtMeditationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
  private val binding = ItemMtMeditationBinding.bind(view)

  fun bind(meditation : MeditationUIModel) = with(binding){
    ivMeditation.setUrl(meditation.image.large)
    tvTitle.text = meditation.title
    tvSubtitle.text = meditation.subTitle
  }
}