package com.domain.visor.school.kh.features.auth.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.common.AppLoadingAnimation
import com.domain.visor.school.kh.features.auth.presentation.components.footer.FooterLoginScreen
import com.domain.visor.school.kh.features.auth.presentation.components.header.HeaderLoginScreen
import com.domain.visor.school.kh.features.auth.presentation.viewmodel.LoginScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreenActivity : ComponentActivity()
{
    companion object
    {
        fun onNewInstance(activity: Activity): Intent
        {
            return Intent(activity, LoginScreenActivity::class.java)
        }
    }

    private lateinit var activity: Activity
    private val viewmodel: LoginScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        activity = this@LoginScreenActivity
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                val loading = viewmodel.loadingState.observeAsState(false).value
                AppLoadingAnimation(state = loading)
                body(padding = padding)
            }
        }
    }

    @Composable
    private fun body(padding: PaddingValues)
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white)),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HeaderLoginScreen(
                    top = padding.calculateTopPadding(),
                    backed = {

                    }
                )
                FooterLoginScreen(
                    bottom = padding.calculateBottomPadding(),
                    clickLogin = {

                    },
                    forgetPassClick = {

                    }
                )
            }
        }
    }
}