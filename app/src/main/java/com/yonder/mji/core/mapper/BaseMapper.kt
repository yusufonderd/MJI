package com.yonder.mji.core.mapper

interface BaseMapper <in IN , out OUT> {
  fun map(input : IN) : OUT
}