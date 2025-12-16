package com.domain.visor.school.kh.features.onboard.presentation.viewmodel

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState:  MutableLiveData<String> = MutableLiveData()
    val uiState: LiveData<String> = _uiState
    
    fun onAsyncDataInfo(activity: Activity) {
        viewModelScope.launch {
            configure(activity = activity, tag = "km")
            _uiState.postValue("km")
        }
    }
    
    private fun configure(activity: Activity, tag: String) {
        val config = activity.resources.configuration
        val local = Locale(tag)
        Locale.setDefault(local)
        config.setLocale(local)
        activity.createConfigurationContext(config)
    }
    
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}