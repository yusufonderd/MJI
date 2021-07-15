package com.yonder.mji.core.utils.decider

import com.yonder.mji.core.utils.date.DateUtils
import com.yonder.mji.core.utils.date.DateUtils.toDateFormat
import java.util.*
import javax.inject.Inject

private const val EPOCH_TIME_RATIO = 1000
class DateFormatDecider @Inject constructor() {

  fun formatEpochTime(source: String?): String{
    return source?.toLongOrNull()?.let {
      val date = Date(it * EPOCH_TIME_RATIO)
      date.toDateFormat(DateUtils.DEFAULT_TARGET_DATE_FORMAT)
    } ?: run {
      source.orEmpty()
    }
  }
}