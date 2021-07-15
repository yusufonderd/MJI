package com.yonder.mji.core.mapper


class BaseListMapperImpl<I, O>(
  private val mapper: BaseMapper<I, O>
) : BaseListMapper<I, O> {
  override fun map(input: List<I>): List<O> {
    return input.map { mapper.map(it) }
  }
}
