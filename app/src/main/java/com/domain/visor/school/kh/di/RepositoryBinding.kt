package com.domain.visor.school.kh.di

import com.domain.visor.school.kh.features.onBoard.data.repository.OnboardingRepositoryImpl
import com.domain.visor.school.kh.features.onBoard.domain.repository.OnboardingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryBinding {
    @Binds
    fun onBindOnboardingRepository(impl: OnboardingRepositoryImpl): OnboardingRepository
}