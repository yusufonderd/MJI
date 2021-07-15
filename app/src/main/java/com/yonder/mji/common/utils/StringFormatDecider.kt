package com.yonder.mji.common.utils

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*
import javax.inject.Inject

class StringFormatDecider @Inject constructor(
  @ApplicationContext private val context: Context
) {
  fun format(@StringRes resId: Int, other: String?): String {
    return try {
      context.getString(
        resId,
        other
      )
    }catch (e : MissingFormatArgumentException){
      "$other"
    }
  }
}
