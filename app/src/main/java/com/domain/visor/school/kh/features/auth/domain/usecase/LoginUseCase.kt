package com.domain.visor.school.kh.features.auth.domain.usecase

import com.domain.visor.school.core_executor.helper.Resource
import com.domain.visor.school.kh.features.auth.domain.model.DataLoginModel
import com.domain.visor.school.kh.features.auth.domain.repository.LoginRepository
import com.domain.visor.school.kh.features.onboard.domain.model.DataOnboardingModel
import com.domain.visor.school.kh.features.onboard.domain.repository.OnboardingRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    operator fun invoke(): Flow<Resource<DataLoginModel>> = flow {
        try {
            val result = repository.onUserLogin()
            emit(value = Resource.Success(data = result))
        } catch (e: Exception) {
            emit(value = Resource.Error(message = "${e.message}"))
        }
    }
}