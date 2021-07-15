package com.yonder.mji.core.utils.date

import java.text.SimpleDateFormat
import java.util.*
object DateUtils {
  fun Date.toDateFormat(dateFormat: String, locale: Locale = Locale.getDefault()): String {
    return SimpleDateFormat(dateFormat, locale).format(this)
  }
  const val DEFAULT_TARGET_DATE_FORMAT = "dd/MM/yyyy, EEE"
}