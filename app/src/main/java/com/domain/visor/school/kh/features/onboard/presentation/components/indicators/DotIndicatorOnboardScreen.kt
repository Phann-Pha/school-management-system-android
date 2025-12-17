package com.domain.visor.school.kh.features.onboard.presentation.components.indicators

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.domain.visor.school.kh.R

@Composable
fun DotIndicatorOnboardingScreen(state: PagerState)
{
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .background(color = colorResource(id = R.color.transparent))
            .padding(all = 2.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(times = state.pageCount) { iteration ->
            val iterated = state.currentPage == iteration
            Box(
                modifier = Modifier
                    .width(width = if (iterated) 56.dp else 16.dp)
                    .height(height = 10.dp)
                    .padding(horizontal = 2.dp)
                    .clip(shape = RoundedCornerShape(corner = CornerSize(size = 4.dp)))
                    .background(color = colorResource(id = if (iterated) R.color.active_dot_indicator else R.color.disactive_dot_indicator))
            )
        }
    }
}


