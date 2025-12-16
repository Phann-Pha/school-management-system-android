package com.domain.visor.school.kh.features.language.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SelectingLanguageScreenViewModel: ViewModel() {
    
    private val _uiState:  MutableLiveData<Boolean> = MutableLiveData()
    val uiState: LiveData<Boolean> = _uiState
    
    fun onUpdateLanguage(status: String) {
        viewModelScope.launch {
            _uiState.postValue(true)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}