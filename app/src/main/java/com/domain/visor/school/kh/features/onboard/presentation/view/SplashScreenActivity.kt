package com.domain.visor.school.kh.features.onboard.presentation.view

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.base.BaseComponentActivity
import com.domain.visor.school.kh.common.AppLoadingAnimation
import com.domain.visor.school.kh.features.language.presentation.view.SelectingLanguageScreenActivity
import com.domain.visor.school.kh.features.onboard.presentation.viewmodel.SplashScreenViewModel

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : BaseComponentActivity()
{
    private lateinit var activity: Activity
    private val viewmodel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        activity = this@SplashScreenActivity
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                val loading = viewmodel.onLoadingAnimationState.observeAsState().value ?: false
                AppLoadingAnimation(state = loading)
                body(padding = padding)
            }
        }

        viewmodel.onAsyncDataInfo()
        onObservableViewModel()
    }

    @Composable
    private fun body(padding: PaddingValues)
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = padding.calculateTopPadding(), bottom = padding.calculateBottomPadding()),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(size = 0.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 250.dp)
                        .background(color = colorResource(id = R.color.white)),
                    painter = painterResource(id = R.drawable.onboard_3),
                    contentDescription = null
                )
                Text(
                    text = stringResource(id = R.string.app_version),
                    fontSize = 13.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }

    private fun onObservableViewModel()
    {
        viewmodel.onAsyncDataInfoState.observe(this) {
            startActivity(SelectingLanguageScreenActivity.onNewInstance(activity = activity))
            activity.finish()
        }
    }
}