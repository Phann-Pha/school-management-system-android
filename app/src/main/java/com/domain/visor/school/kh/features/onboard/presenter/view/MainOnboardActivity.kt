package com.domain.visor.school.kh.features.onboard.presenter.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.domain.visor.school.kh.features.onboard.presenter.viewmodel.MainOnboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainOnboardActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainOnboardActivity"
        fun onInstance(activity: Activity) = Intent(activity, MainOnboardActivity::class.java)
    }

    private val viewmodel: MainOnboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { _ ->

            }
        }

        onGlobalSync()
    }

    private fun onGlobalSync() {
        viewmodel.onGlobalSync()
    }
}