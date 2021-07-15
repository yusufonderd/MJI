package com.yonder.mji.data.local.usecase

interface UserPreferenceUseCase {
  fun getUsername(): String
  fun saveUsername(username: String)
}