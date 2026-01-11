package com.domain.visor.school.kh.features.auth.domain.usecase

import com.domain.visor.school.core_executor.helper.Resource
import com.domain.visor.school.datastore.utils.deSerializeData
import com.domain.visor.school.kh.features.auth.data.model.DataLoginDto
import com.domain.visor.school.kh.features.auth.domain.model.DataLoginModel
import com.domain.visor.school.kh.features.auth.domain.repository.LoginRepository
import com.domain.visor.school.retrofit_client.services.User
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    operator fun invoke(user: User): Flow<Resource<DataLoginModel>> = flow {
        try
        {
            val response = repository.onUserLogin(user)
            if (response.isSuccessful && response.body() != null)
            {
                val raw = response.body()?.string().orEmpty()
                val dto : DataLoginDto = deSerializeData(raw)
                if (dto.status == true)
                {
                    emit(value = Resource.Success(data = dto.toDataUserLogin()))
                }
                else
                {
                    emit(value = Resource.Error(message = dto.message.orEmpty()))
                }
            }
            else
            {
                emit(value = Resource.Error(message = "Request failed"))
            }
        }
        catch (_: Exception)
        {
            emit(value = Resource.Error(message = "Unknown error occurred"))
        }
    }
}