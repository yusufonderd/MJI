package com.yonder.mji.uicomponent.meditationview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yonder.mji.R
import com.yonder.mji.common.base.BaseListAdapter
import com.yonder.mji.scenes.home.domain.model.MeditationUIModel
import javax.inject.Inject


class MtMeditationAdapter @Inject constructor(private val onClickMeditation: ((meditation: MeditationUIModel) -> Unit)?) : BaseListAdapter<MeditationUIModel>(
  itemsSame = { old, new -> old.title === new.title },
  contentsSame = { old, new -> old == new }
) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    inflater: LayoutInflater,
    viewType: Int
  ): RecyclerView.ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mt_meditation, parent, false)
    return MtMeditationViewHolder(view,onClickMeditation)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    when(holder){
      is MtMeditationViewHolder ->{
        holder.bind(getItem(position))
      }
    }
  }

}
