package com.domain.visor.school.kh.features.auth.domain.usecase

import com.domain.visor.school.core_executor.helper.Resource
import com.domain.visor.school.datastore.utils.deSerializeData
import com.domain.visor.school.kh.features.auth.data.dto.DataUserLoginDto
import com.domain.visor.school.kh.features.auth.domain.model.DataUserLoginModel
import com.domain.visor.school.kh.features.auth.domain.repository.LoginUserAccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserLoginUseCase @Inject constructor(private val repository: LoginUserAccountRepository)
{
    operator fun invoke(email: String, password: String): Flow<Resource<DataUserLoginModel>> = flow {
        try
        {
            val response = repository.onLoginUserAccount(email = email, password = password)
            if (response.isSuccessful && response.body() != null)
            {
                val raw = response.body()?.string().orEmpty()
                val dto : DataUserLoginDto = deSerializeData(raw)
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