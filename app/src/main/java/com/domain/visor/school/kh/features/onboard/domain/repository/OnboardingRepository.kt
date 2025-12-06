package com.domain.visor.school.kh.features.onboard.domain.repository

import com.domain.visor.school.kh.features.onboard.domain.model.DataOnboardingModel

interface OnboardingRepository {
    fun onAsyncOnboardingInfo(): List<DataOnboardingModel>
}