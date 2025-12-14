package com.domain.visor.school.kh.features.language.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.language.presentation.components.footer.FooterSelectingLanguageScreen
import com.domain.visor.school.kh.features.language.presentation.components.header.HeaderSelectingLanguageScreen
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
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.white)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        HeaderSelectingLanguageScreen(statusBarHeight = padding.calculateTopPadding(), backed = {
                            // action back
                        })
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 250.dp)
                                .background(colorResource(id = R.color.white)),
                            painter = painterResource(id = R.drawable.onboard_3),
                            contentDescription = null
                        )
                        FooterSelectingLanguageScreen(navigateBottomHeight = padding.calculateBottomPadding())
                    }
                }
            }
        }
    }
}