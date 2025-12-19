package com.domain.visor.school.kh.features.language.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.base.BaseComponentActivity
import com.domain.visor.school.kh.common.AppLoadingAnimation
import com.domain.visor.school.kh.features.language.presentation.components.footer.FooterSelectingLanguageScreen
import com.domain.visor.school.kh.features.language.presentation.components.header.HeaderSelectingLanguageScreen
import com.domain.visor.school.kh.features.language.presentation.viewmodel.SelectingLanguageScreenViewModel
import com.domain.visor.school.kh.features.onboard.presentation.view.GetStartingScreenActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectingLanguageScreenActivity : BaseComponentActivity()
{
    companion object
    {
        fun onNewInstance(activity: Activity): Intent
        {
            return Intent(activity, SelectingLanguageScreenActivity::class.java)
        }
    }

    private lateinit var activity: Activity
    private val viewmodel: SelectingLanguageScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        activity = this@SelectingLanguageScreenActivity
        super.onCreate(savedInstanceState)
        onChangeIconStatusBarColor(light = true)
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->

                val loading = viewmodel.loadingState.observeAsState().value ?: false
                AppLoadingAnimation(state = loading)
                body(padding = padding)
            }
        }

        onObservableViewModel()
    }

    @Composable
    private fun body(padding: PaddingValues)
    {
        val code: String = viewmodel.onGetLanguageCode(context = activity)
        var current: String by remember { mutableStateOf(value = code) }
        val language = remember { mutableStateOf(value = current) }

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
                HeaderSelectingLanguageScreen(
                    top = padding.calculateTopPadding(),
                    backed = {
                        finish()
                    }
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 250.dp)
                        .background(color = colorResource(id = R.color.white)),
                    painter = painterResource(id = R.drawable.onboard_3),
                    contentDescription = null
                )
                FooterSelectingLanguageScreen(
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