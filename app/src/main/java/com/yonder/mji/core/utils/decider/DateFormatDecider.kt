package com.yonder.mji.core.utils.decider

import com.yonder.mji.core.utils.date.DateUtils
import com.yonder.mji.core.utils.date.DateUtils.toDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatDecider @Inject constructor() {

  fun formatEpochTime(source: String?): String{
    return source?.toLongOrNull()?.let {
      val date = Date(it * 1000)
      date.toDateFormat(DateUtils.DEFAULT_TARGET_DATE_FORMAT)
    } ?: run {
      source.orEmpty()
    }
  }
}