package com.yonder.mji.core.utils.date

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

  private fun toDate(
    source: String?,
    sourceDateFormat: String = SOURCE_DATE_FORMAT,
    timeZone: String = DEFAULT_TIME_ZONE,
    locale: Locale = Locale.getDefault()
  ): Date? {
    val tz: TimeZone = TimeZone.getTimeZone(timeZone)
    return try {
      val df: DateFormat = SimpleDateFormat(sourceDateFormat, locale)
      df.timeZone = tz
      df.parse(source.orEmpty())
    } catch (e: ParseException) {
      null
    }
  }

  fun toDateString(
    source: String?,
    sourceDateFormat: String = SOURCE_DATE_FORMAT,
    targetDateFormat: String = DEFAULT_TARGET_DATE_FORMAT
  ): String {
    val date = toDate(source, sourceDateFormat)
    return date?.toDateFormat(targetDateFormat).orEmpty()
  }


  fun Date.toDateFormat(dateFormat: String, locale: Locale = Locale.getDefault()): String {
    return SimpleDateFormat(dateFormat, locale).format(this)
  }

  const val DEFAULT_TARGET_DATE_FORMAT = "dd MMM yyyy HH:mm"
  private const val DEFAULT_TIME_ZONE = "UTC"
  const val SOURCE_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

}