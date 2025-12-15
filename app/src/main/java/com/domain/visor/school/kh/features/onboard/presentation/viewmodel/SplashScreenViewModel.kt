package com.domain.visor.school.kh.features.onboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState:  MutableLiveData<String> = MutableLiveData()
    val uiState: LiveData<String> = _uiState
    
    init {
        onAsyncOnboardingInfo()
    }
    
    private fun onAsyncOnboardingInfo() {
        viewModelScope.launch {
            delay(timeMillis = 3000L)
            _uiState.value = "done"
        }
    }
    
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}