package com.yonder.mji.core.utils

import org.junit.Test

class RegexValidatorTest {

  private val PASSWORD_REGEX_PATTERN = "^(?=.*?[A-Z])(?=.*?[0-9]).{6,}$"

  var validator = RegexValidator(PASSWORD_REGEX_PATTERN)

  @Test
  fun `given regex pattern ,when check is valid, then returns true`() {
    //then
    assert(validator.isValid("YusufMJI3"))
    assert(validator.isValid("YusufM3"))
  }

  @Test
  fun `given regex pattern ,when check validation, then returns false`() {
    //then
    assert(!validator.isValid("yus4F"))
    assert(!validator.isValid(""))
    assert(!validator.isValid("yusuf"))
  }

}