package com.domain.visor.school.kh.features.onboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState = MutableStateFlow(value = "")
    val uiState: StateFlow<String> = _uiState.asStateFlow()
    
    init {
        onAsyncOnboardingInfo()
    }
    
    private fun onAsyncOnboardingInfo() {
        viewModelScope.launch {
        
        }
    }
    
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}