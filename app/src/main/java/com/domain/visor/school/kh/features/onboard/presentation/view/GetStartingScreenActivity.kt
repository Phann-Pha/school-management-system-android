package com.domain.visor.school.kh.features.onboard.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.domain.visor.school.kh.features.onboard.presentation.components.footer.FooterGetStartingScreen
import com.domain.visor.school.kh.features.onboard.presentation.components.header.HeaderGetStartingScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetStartingScreenActivity : ComponentActivity() {
    companion object {
        private const val TAG = "GetStartingActivity"
        fun onInstance(activity: Activity) = Intent(activity, GetStartingScreenActivity::class.java)
    }

    private lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        activity = this@GetStartingScreenActivity
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.white)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    HeaderGetStartingScreen(statusBarHeight = padding.calculateTopPadding(), backed = { finish() }) {
                        // Handle skip action
                    }
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 250.dp)
                            .background(colorResource(id = R.color.white)),
                        painter = painterResource(id = R.drawable.image_get_starting),
                        contentDescription = null
                    )
                    FooterGetStartingScreen(navigateBottomHeight = padding.calculateBottomPadding()) {
                        // Handle clicked action
                        startActivity(OnboardingScreenActivity.onInstance(activity = activity))
                        finish()
                    }
                }
            }
        }
    }
}