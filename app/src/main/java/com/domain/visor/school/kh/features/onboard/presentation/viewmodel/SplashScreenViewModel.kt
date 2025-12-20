package com.domain.visor.school.kh.features.onboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel()
{
    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> = _loadingState

    private val _onAsyncDataInfoState: MutableLiveData<String> = MutableLiveData()
    val onAsyncDataInfoState: LiveData<String> = _onAsyncDataInfoState

    fun onAsyncDataInfo()
    {
        _loadingState.postValue(true)
        viewModelScope.launch {
            delay(timeMillis = 1000L)
            _loadingState.postValue(false)
            _onAsyncDataInfoState.postValue("some data")
        }
    }

    override fun onCleared()
    {
        super.onCleared()
        viewModelScope.cancel()
    }
}