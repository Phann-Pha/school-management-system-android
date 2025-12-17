package com.domain.visor.school.kh.features.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

class LoginScreenViewModel : ViewModel()
{
    override fun onCleared()
    {
        super.onCleared()
        viewModelScope.cancel()
    }
}