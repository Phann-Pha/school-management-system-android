package com.domain.visor.school.kh.features.auth.data.repository

import com.domain.visor.school.kh.features.auth.domain.repository.LoginUserAccountRepository
import com.domain.visor.school.retrofit_client.services.APIInterface
import com.domain.visor.school.retrofit_client.services.User
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

@ViewModelScoped
class LoginUserAccountRepositoryImpl @Inject constructor(
    @param:Named("API") private val api: APIInterface
) : LoginUserAccountRepository
{
    override suspend fun onLoginUserAccount(email: String, password: String): Response<ResponseBody>
    {
        val user = User(email = email, password = password)
        return api.onLoginUserAccount(user)
    }
}