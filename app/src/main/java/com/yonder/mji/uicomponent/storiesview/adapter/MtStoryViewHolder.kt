package com.yonder.mji.uicomponent.storiesview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yonder.mji.core.extensions.setUrl
import com.yonder.mji.databinding.ItemMtStoryBinding
import com.yonder.mji.scenes.home.domain.model.StoryUIModel


class MtStoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
  private val binding = ItemMtStoryBinding.bind(view)

  fun bind(story : StoryUIModel) = with(binding){
    ivStory.setUrl(story.image.large)
    tvTitle.text = story.name
    tvSubtitle.text = story.category
  }
}