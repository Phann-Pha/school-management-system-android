package com.domain.visor.school.kh.features.auth.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.common.AppLoadingAnimation
import com.domain.visor.school.kh.features.auth.presentation.components.form.CustomTextField
import com.domain.visor.school.kh.features.auth.presentation.components.form.LoginButtonForm
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
                MainContent(padding = padding)
            }
        }
    }

    @Composable
    private fun MainContent(padding: PaddingValues)
    {
        //val keyboardController = LocalSoftwareKeyboardController.current

        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(
                    state = rememberScrollableState { 1f },
                    enabled = true,
                    orientation = Orientation.Vertical
                )
                .background(color = colorResource(id = R.color.white)),
            contentAlignment = Alignment.TopCenter,
        ) {
            // Content
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = .85f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 250.dp),
                    painter = painterResource(id = R.drawable.onboard_3),
                    contentDescription = null
                )
                CustomTextField(
                    value = username,
                    placeholder = stringResource(id = R.string.user_name),
                    onValueChange = { username.value = it }
                )
                Spacer(modifier = Modifier.height(height = 12.dp))
                CustomTextField(
                    value = password,
                    placeholder = stringResource(id = R.string.password),
                    onValueChange = { password.value = it }
                )
                Spacer(modifier = Modifier.height(height = 42.dp))
                LoginButtonForm()
            }

            // Header
            HeaderLoginScreen(
                top = padding.calculateTopPadding(),
                backed = { finish() }
            )
        }
    }
}