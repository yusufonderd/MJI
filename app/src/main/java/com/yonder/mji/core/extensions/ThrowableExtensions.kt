package com.yonder.mji.core.extensions

val Throwable?.humanReadableMessage get() = this?.localizedMessage ?: this?.message ?: "Error Occurred"