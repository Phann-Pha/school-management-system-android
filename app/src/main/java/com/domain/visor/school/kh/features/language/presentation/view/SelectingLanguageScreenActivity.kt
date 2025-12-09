package com.domain.visor.school.kh.features.language.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.domain.visor.school.kh.features.language.presentation.viewmodel.SelectingLanguageScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectingLanguageScreenActivity : ComponentActivity() {
    companion object {
        private const val TAG = "SelectingLanguageScreenActivity"
        fun onNewInstance(activity: Activity) = Intent(activity, SelectingLanguageScreenActivity::class.java)
    }

    private lateinit var activity: Activity
    private val viewmodel: SelectingLanguageScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        activity = this@SelectingLanguageScreenActivity
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Selecting Language Screen")
                }
            }
        }
    }
}