package com.domain.visor.school.kh.features.onboard.data.repository

import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.onboard.domain.model.DataOnboardingModel
import com.domain.visor.school.kh.features.onboard.domain.repository.OnboardingRepository
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor() : OnboardingRepository {
    override fun onAsyncOnboardingInfo(): List<DataOnboardingModel> {
        return listOf(
            DataOnboardingModel(
                thumbnail = R.drawable.onboard_1,
                description = R.string.description_onboard_1
            ),
            DataOnboardingModel(
                thumbnail = R.drawable.onboard_2,
                description = R.string.description_onboard_2
            ),
            DataOnboardingModel(
                thumbnail = R.drawable.onboard_3,
                description = R.string.description_onboard_3
            )
        )
    }
}