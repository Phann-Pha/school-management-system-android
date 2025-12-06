package com.domain.visor.school.kh.features.onBoard.domain.repository

import com.domain.visor.school.kh.features.onBoard.domain.model.DataOnboardingModel

interface OnboardingRepository {
    fun onAsyncOnboardingInfo(): List<DataOnboardingModel>
}