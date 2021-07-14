package com.yonder.mji.core.utils

import java.util.regex.Pattern

class RegexValidator(regex: String) {
  var pattern: Pattern = Pattern.compile(regex)

   fun isValid(s: CharSequence): Boolean {
    return pattern.matcher(s).matches()
  }
}