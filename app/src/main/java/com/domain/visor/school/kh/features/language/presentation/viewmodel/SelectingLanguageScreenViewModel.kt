package com.domain.visor.school.kh.features.language.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.visor.school.datastore.LanguageSettingManager
import com.domain.visor.school.kh.features.language.domain.LanguageStatus
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SelectingLanguageScreenViewModel: ViewModel() {
    
    private val _uiState:  MutableLiveData<String> = MutableLiveData()
    val uiState: LiveData<String> = _uiState
    
    fun onUpdateLanguage(lang: LanguageSettingManager, status: LanguageStatus) {
        viewModelScope.launch {
            when(status) {
                LanguageStatus.ENGLISH -> {
                    lang.update(value = lang.en)
                    _uiState.postValue(lang.en)
                }
                LanguageStatus.KHMER -> {
                    lang.update(value = lang.km)
                    _uiState.postValue(lang.km)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}