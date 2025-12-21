package com.domain.visor.school.kh.features.auth.domain.repository

import com.domain.visor.school.kh.features.onboard.domain.model.DataOnboardingModel

interface LoginRepository {
    fun onUserLogin(): List<DataOnboardingModel>
}