package com.domain.visor.school.kh.features.auth.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.visor.school.core_executor.helper.Resource
import com.domain.visor.school.kh.features.auth.domain.model.DataUserLoginModel
import com.domain.visor.school.kh.features.auth.domain.usecase.UserLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(private val userLoginUseCase: UserLoginUseCase) : ViewModel()
{
    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> = _loadingState

    private val _userDataLoginState: MutableLiveData<DataUserLoginModel?> = MutableLiveData()
    val userDataLoginState: LiveData<DataUserLoginModel?> = _userDataLoginState

    private val _errorMessageState: MutableLiveData<String> = MutableLiveData()
    val errorMessageState: LiveData<String> = _errorMessageState

    init
    {
        onVerifyLoginInfo(
            email = "admin@school.com",
            password = "Admin@123456"
        )
    }

    fun onVerifyLoginInfo(email: String, password: String)
    {
        _loadingState.postValue(true)
        viewModelScope.launch {
            userLoginUseCase
                .invoke(email, password)
                .collect { result ->
                    when (result)
                    {
                        is Resource.Success ->
                        {
                            _loadingState.postValue(false)
                            _userDataLoginState.postValue(result.data)
                        }

                        is Resource.Error   ->
                        {
                            _loadingState.postValue(false)
                            _errorMessageState.postValue(result.message.orEmpty())
                        }
                    }
                }
        }
    }

    override fun onCleared()
    {
        super.onCleared()
        viewModelScope.cancel()
    }
}