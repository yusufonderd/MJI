package com.yonder.mji.core.utils.decider

import org.junit.Test
import java.util.*


class DateFormatDeciderTest {

  private val decider = DateFormatDecider()

  @Test
  fun `given epoch time ,when format epoch time, then matches correct formatted date`() {
    //given
    val epochTime = "1614246146"

    //when
    val formattedDateEn = decider.formatEpochTime(epochTime, Locale.ENGLISH)
    val formattedDateTr = decider.formatEpochTime(epochTime, Locale("tr"))

    //then
    assert(formattedDateEn == "25/02/2021, Thu")
    assert(formattedDateTr == "25/02/2021, Per")
  }

}