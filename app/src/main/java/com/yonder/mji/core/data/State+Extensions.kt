package com.yonder.mji.core.data

fun <T, R> State<T>.map(transform: (T) -> R): State<R> {
  return when (this) {
    is State.Success -> State.Success(transform(data))
    is State.Error -> State.Error(exception)
    is State.Loading -> State.Loading
  }
}
