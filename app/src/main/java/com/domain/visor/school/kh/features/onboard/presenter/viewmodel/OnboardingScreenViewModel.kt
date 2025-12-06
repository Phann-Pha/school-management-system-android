package com.domain.visor.school.kh.features.onBoard.presenter.viewModel

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.visor.school.core_executor.helper.Resource
import com.domain.visor.school.kh.features.onBoard.domain.model.DataOnboardingModel
import com.domain.visor.school.kh.features.onBoard.domain.usecase.AsyncOnboardingInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenViewModel @Inject constructor(private val useCase: AsyncOnboardingInfoUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(value = emptyList<DataOnboardingModel>())
    val uiState: StateFlow<List<DataOnboardingModel>> = _uiState.asStateFlow()

    init {
        onAsyncOnboardingInfo()
    }

    private fun onAsyncOnboardingInfo() {
        viewModelScope.launch {
            useCase.invoke().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _uiState.value = result.data ?: emptyList()
                    }

                    is Resource.Error -> {
                        // notify error
                    }
                }
            }
        }
    }
}