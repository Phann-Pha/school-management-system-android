package com.domain.visor.school.kh.features.onboard.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.base.BaseComponentActivity
import com.domain.visor.school.kh.features.auth.presentation.view.LoginScreenActivity
import com.domain.visor.school.kh.features.onboard.presentation.components.cards.CardItemOnboardingScreen
import com.domain.visor.school.kh.features.onboard.presentation.components.footer.FooterOnboardingScreen
import com.domain.visor.school.kh.features.onboard.presentation.components.header.HeaderOnboardingScreen
import com.domain.visor.school.kh.features.onboard.presentation.viewmodel.OnboardingScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OnboardingScreenActivity : BaseComponentActivity()
{
    companion object
    {
        fun onNewInstance(activity: Activity): Intent
        {
            return Intent(activity, OnboardingScreenActivity::class.java)
        }
    }

    private lateinit var activity: Activity
    private val viewmodel: OnboardingScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        activity = this@OnboardingScreenActivity
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
        var count = 0
        val items = viewmodel.uiState.collectAsState(context = Dispatchers.Default).value
        val state = rememberPagerState(pageCount = { items.count() })
        val scope = rememberCoroutineScope()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HeaderOnboardingScreen(
                    top = padding.calculateTopPadding(),
                    skip = {
                        onSkip()
                    }
                )
                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(color = colorResource(id = R.color.white)),
                    state = state,
                    userScrollEnabled = false
                ) { page -> CardItemOnboardingScreen(item = items[page], state = state, page = page) }
                FooterOnboardingScreen(
                    navigateBottomHeight = padding.calculateBottomPadding(),
                    state = state,
                    clicked = {
                        scope.launch {
                            val next = (state.currentPage + 1).coerceAtMost(maximumValue = state.pageCount - 1)
                            state.animateScrollToPage(page = next)

                            if (next == state.pageCount - 1)
                            {
                                if (count == state.pageCount)
                                {
                                    onNavigateToLoginScreen()
                                }
                                count = next + 1
                            }
                        }
                    }
                )
            }
        }
    }

    private fun onNavigateToLoginScreen()
    {
        startActivity(LoginScreenActivity.onNewInstance(activity = activity))
        activity.finish()
    }

    private fun onSkip()
    {
        startActivity(LoginScreenActivity.onNewInstance(activity = activity))
        activity.finish()
    }
}