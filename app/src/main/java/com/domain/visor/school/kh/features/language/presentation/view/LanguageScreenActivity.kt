package com.domain.visor.school.kh.features.language.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import com.domain.visor.school.kh.common.AppLoadingAnimation
import com.domain.visor.school.kh.features.language.presentation.components.footer.FooterLanguageScreen
import com.domain.visor.school.kh.features.language.presentation.components.header.HeaderLanguageScreen
import com.domain.visor.school.kh.features.language.presentation.viewmodel.LanguageScreenViewModel
import com.domain.visor.school.kh.features.onboard.presentation.view.GetStartingScreenActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LanguageScreenActivity : BaseComponentActivity()
{
    companion object
    {
        fun onNewInstance(activity: Activity): Intent
        {
            return Intent(activity, LanguageScreenActivity::class.java)
        }
    }

    private lateinit var activity: Activity
    private val viewmodel: LanguageScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        activity = this@LanguageScreenActivity
        super.onCreate(savedInstanceState)
        onChangeIconStatusBarColor(light = true)
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->

                val loading = viewmodel.loadingState.observeAsState().value ?: false
                AppLoadingAnimation(state = loading)
                MainContent(padding = padding)
            }
        }

        onObservableViewModel()
    }

    @Composable
    private fun MainContent(padding: PaddingValues)
    {
        val code: String = viewmodel.onGetLanguageCode(context = activity)
        var current: String by remember { mutableStateOf(value = code) }
        val language = remember { mutableStateOf(value = current) }

        val spec = LottieCompositionSpec.RawRes(resId = R.raw.study_anim)
        val animation by rememberLottieComposition(spec = spec)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HeaderLanguageScreen(
                    top = padding.calculateTopPadding(),
                    backed = { finish() }
                )
                LottieAnimation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 280.dp),
                    composition = animation,
                    iterations = LottieConstants.IterateForever
                )
                FooterLanguageScreen(
                    bottom = padding.calculateBottomPadding(),
                    language = language,
                    clicked = { code ->
                        current = code
                        onProcessLanguage(code = code)
                    }
                )
            }
        }
    }

    private fun onProcessLanguage(code: String)
    {
        viewmodel.onChangedLanguage(context = activity, code = code)
    }

    private fun onObservableViewModel()
    {
        viewmodel.changingState.observe(this) { state ->
            if (state)
            {
                startActivity(GetStartingScreenActivity.onNewInstance(activity = activity))
            }
        }
    }
}