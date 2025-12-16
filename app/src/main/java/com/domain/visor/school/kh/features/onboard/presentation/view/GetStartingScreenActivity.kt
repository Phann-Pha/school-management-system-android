package com.domain.visor.school.kh.features.onboard.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.base.BaseComponentActivity
import com.domain.visor.school.kh.features.onboard.presentation.components.footer.FooterGetStartingScreen
import com.domain.visor.school.kh.features.onboard.presentation.components.header.HeaderGetStartingScreen
import com.domain.visor.school.kh.features.onboard.presentation.viewmodel.GetStartingScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetStartingScreenActivity : BaseComponentActivity() {
    
    companion object {
        fun onNewInstance(activity: Activity) : Intent {
            return Intent(activity, GetStartingScreenActivity::class.java)
        }
    }

    private lateinit var activity: Activity
    private val viewmodel: GetStartingScreenViewModel by viewModels()

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
                    HeaderGetStartingScreen(top = padding.calculateTopPadding(), backed = { finish() }, skip = { finish() })
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 260.dp)
                            .background(color = colorResource(id = R.color.white)),
                        painter = painterResource(id = R.drawable.image_get_starting),
                        contentDescription = null
                    )
                    FooterGetStartingScreen(bottom = padding.calculateBottomPadding()) {
                        startActivity(OnboardingScreenActivity.onNewInstance(activity = activity))
                        finish()
                    }
                }
            }
        }
    }
}