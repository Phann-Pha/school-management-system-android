package com.domain.visor.school.kh.di

import com.domain.visor.school.kh.features.auth.data.repository.LoginUserAccountRepositoryImpl
import com.domain.visor.school.kh.features.auth.domain.repository.LoginUserAccountRepository
import com.domain.visor.school.kh.features.onboard.data.repository.OnboardingRepositoryImpl
import com.domain.visor.school.kh.features.onboard.domain.repository.OnboardingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryBinding
{
    @Binds
    fun onBindOnboardingRepository(impl: OnboardingRepositoryImpl): OnboardingRepository

    @Binds
    fun onBindUserLoginRepository(impl: LoginUserAccountRepositoryImpl): LoginUserAccountRepository
}