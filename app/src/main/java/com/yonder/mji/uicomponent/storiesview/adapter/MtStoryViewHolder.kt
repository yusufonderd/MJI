package com.yonder.mji.uicomponent.storiesview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yonder.mji.core.extensions.setImageUrl
import com.yonder.mji.databinding.ItemMtStoryBinding
import com.yonder.mji.scenes.home.domain.model.StoryUIModel


class MtStoryViewHolder(view: View,
  private val onClickStory: ((story: StoryUIModel) -> Unit)?) :
  RecyclerView.ViewHolder(view) {
  private val binding = ItemMtStoryBinding.bind(view)

  fun bind(story: StoryUIModel) = with(binding) {
    ivStory.setImageUrl(story.image.small)
    tvTitle.text = story.name
    tvSubtitle.text = story.category
    itemView.setOnClickListener {
      onClickStory?.invoke(story)
    }
  }
}