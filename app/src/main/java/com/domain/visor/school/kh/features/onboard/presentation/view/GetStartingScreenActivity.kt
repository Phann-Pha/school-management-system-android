package com.domain.visor.school.kh.features.onboard.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.base.BaseComponentActivity
import com.domain.visor.school.kh.features.onboard.presentation.components.footer.FooterGetStartingScreen
import com.domain.visor.school.kh.features.onboard.presentation.components.header.HeaderGetStartingScreen
import com.domain.visor.school.kh.features.onboard.presentation.viewmodel.GetStartingScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetStartingScreenActivity : BaseComponentActivity()
{
    companion object
    {
        fun onNewInstance(activity: Activity): Intent
        {
            return Intent(activity, GetStartingScreenActivity::class.java)
        }
    }

    private lateinit var activity: Activity
    private val viewmodel: GetStartingScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        activity = this@GetStartingScreenActivity
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                body(padding = padding)
            }
        }
    }

    @Composable
    private fun body(padding: PaddingValues)
    {
        val spec = LottieCompositionSpec.RawRes(resId = R.raw.listing_animation)
        val animation by rememberLottieComposition(spec = spec)
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.white)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HeaderGetStartingScreen(
                    top = padding.calculateTopPadding(),
                    backed = { finish() },
                    skip = { finish() }
                )
                LottieAnimation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 280.dp),
                    composition = animation,
                    iterations = LottieConstants.IterateForever
                )
                FooterGetStartingScreen(bottom = padding.calculateBottomPadding(), clicked = {
                    startActivity(OnboardingScreenActivity.onNewInstance(activity = activity))
                    finish()
                })
            }
        }
    }
}