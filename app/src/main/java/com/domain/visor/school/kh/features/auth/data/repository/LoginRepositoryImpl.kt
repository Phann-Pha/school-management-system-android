package com.domain.visor.school.kh.features.auth.data.repository

import android.R.attr.password
import com.domain.visor.school.kh.features.auth.data.model.DataLoginDto
import com.domain.visor.school.kh.features.auth.domain.repository.LoginRepository
import com.domain.visor.school.retrofit_client.services.APIInterface
import com.domain.visor.school.retrofit_client.services.User
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import javax.inject.Inject
import javax.inject.Named

class LoginRepositoryImpl @Inject constructor(
    @param:Named("API") private val api: APIInterface
) : LoginRepository
{
    override suspend fun onUserLogin(user: User): Response<ResponseBody> {
        return api.onLoginUserAccount(user)
    }
}