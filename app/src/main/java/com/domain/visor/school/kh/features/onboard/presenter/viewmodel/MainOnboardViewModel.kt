package com.domain.visor.school.kh.features.onboard.presenter.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainOnboardViewModel @Inject constructor() : ViewModel() {

    fun onGlobalSync() {
        println("syne")
    }
}