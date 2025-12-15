package com.domain.visor.school.kh.features.language.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.visor.school.datastore.LanguageSettingManager
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SelectingLanguageScreenViewModel: ViewModel() {
    
    private val _uiState:  MutableLiveData<Boolean> = MutableLiveData()
    val uiState: LiveData<Boolean> = _uiState
    
    fun onUpdateLanguage(lang: LanguageSettingManager, status: String) {
        viewModelScope.launch {
            _uiState.postValue(lang.update(value = status))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}