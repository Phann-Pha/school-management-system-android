package com.domain.visor.school.kh.features.onboard.presentation.view

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.domain.visor.school.kh.base.BaseComponentActivity
import com.domain.visor.school.kh.features.onboard.presentation.viewmodel.OnboardingScreenViewModel
import kotlin.getValue

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : BaseComponentActivity() {
    
    private lateinit var activity: Activity
    private val viewmodel: OnboardingScreenViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        activity = this@SplashScreenActivity
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
            
            }
        }
    }
}