package com.yonder.mji.uicomponent.storiesview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yonder.mji.R
import com.yonder.mji.core.base.BaseListAdapter
import com.yonder.mji.scenes.home.domain.model.StoryUIModel

class MtStoryAdapter(private val onClickStory: ((story: StoryUIModel) -> Unit)?) :
  BaseListAdapter<StoryUIModel>(
    itemsSame = { old, new -> old.name === new.name },
    contentsSame = { old, new -> old == new }
  ) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    inflater: LayoutInflater,
    viewType: Int
  ): RecyclerView.ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mt_story, parent, false)
    return MtStoryViewHolder(view, onClickStory)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    when (holder) {
      is MtStoryViewHolder -> {
        holder.bind(getItem(position))
      }
    }
  }

}
