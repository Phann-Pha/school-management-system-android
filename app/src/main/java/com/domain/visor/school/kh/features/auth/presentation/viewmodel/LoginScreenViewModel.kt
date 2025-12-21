package com.domain.visor.school.kh.features.auth.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

class LoginScreenViewModel : ViewModel()
{
    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> = _loadingState

    fun onVerifyLoginInfo()
    {
        _loadingState.value = true
    }

    override fun onCleared()
    {
        super.onCleared()
        viewModelScope.cancel()
    }
}