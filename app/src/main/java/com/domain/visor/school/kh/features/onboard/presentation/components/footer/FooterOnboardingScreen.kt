package com.domain.visor.school.kh.features.onboard.presentation.components.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.onboard.presentation.components.buttons.BoundIconButtonAnimation
import com.domain.visor.school.kh.features.onboard.presentation.components.indicators.DotIndicatorOnboardingScreen

@Composable
fun FooterOnboardingScreen(navigateBottomHeight: Dp, state: PagerState, clicked: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.white))
            .padding(bottom = navigateBottomHeight)
            .padding(bottom = 42.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.white))
                .padding(bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.85f)
                    .background(color = colorResource(id = R.color.white)),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.8f)
                        .background(color = colorResource(id = R.color.white)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DotIndicatorOnboardingScreen(state = state)
                    BoundIconButtonAnimation(clicked = clicked)
                }
            }
        }
    }
}