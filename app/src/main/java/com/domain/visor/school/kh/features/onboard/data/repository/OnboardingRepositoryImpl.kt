package com.domain.visor.school.kh.features.onboard.data.repository

import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.onboard.domain.model.DataOnboardingModel
import com.domain.visor.school.kh.features.onboard.domain.repository.OnboardingRepository
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor() : OnboardingRepository
{
    override fun onAsyncOnboardingInfo(): List<DataOnboardingModel>
    {
        return listOf(
            DataOnboardingModel(
                thumbnail = R.raw.analyze_animation,
                description = R.string.description_onboard_1
            ),
            DataOnboardingModel(
                thumbnail = R.raw.scanning_anim,
                description = R.string.description_onboard_2
            ),
            DataOnboardingModel(
                thumbnail = R.raw.listing_animation,
                description = R.string.description_onboard_3
            )
        )
    }
}