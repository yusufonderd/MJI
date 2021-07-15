package com.yonder.mji.core.extensions

fun Int?.orZero() = this ?: 0

fun Boolean?.orFalse() = this ?: false

