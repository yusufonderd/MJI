package com.yonder.mji.uicomponent.storiesview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.yonder.mji.databinding.ViewStoriesBinding
import com.yonder.mji.scenes.home.domain.model.StoryUIModel
import com.yonder.mji.uicomponent.meditationview.adapter.MtMeditationAdapter
import com.yonder.mji.uicomponent.storiesview.adapter.MtStoryAdapter


class MtStoriesView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

  private val binding: ViewStoriesBinding by lazy {
    ViewStoriesBinding.inflate(LayoutInflater.from(context), this, true)
  }

  var onClickStory: ((story: StoryUIModel) -> Unit)? = null

  private val adapter: MtStoryAdapter by lazy {
    MtStoryAdapter(onClickStory)
  }

  fun initView(storyList: List<StoryUIModel>, onClickStory: ((story: StoryUIModel) -> Unit)? = null) {
    this.onClickStory = onClickStory
    binding.recyclerView.adapter = adapter.apply {
      submitList(storyList)
    }
  }
}
