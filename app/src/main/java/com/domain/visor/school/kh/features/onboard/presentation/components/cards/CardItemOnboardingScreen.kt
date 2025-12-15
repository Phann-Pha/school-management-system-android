package com.domain.visor.school.kh.features.onboard.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.onboard.domain.model.DataOnboardingModel
import kotlin.math.absoluteValue

@Composable
internal fun CardItemOnboardingScreen(
    item: DataOnboardingModel,
    state: PagerState,
    page: Int
) {
    val pageOffset = ((state.currentPage - page) + state.currentPageOffsetFraction)

    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
        shape = RoundedCornerShape(size = 0.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = Modifier.graphicsLayer { calculation(pageOffset = pageOffset.absoluteValue) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 250.dp),
                    painter = painterResource(id = item.thumbnail),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(height = 32.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.8f)
                        .background(color = colorResource(id = R.color.transparent))
                        .padding(vertical = 4.dp),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp,
                    softWrap = true,
                    text = stringResource(id = item.description)
                )
            }
        }
    }
}

private fun GraphicsLayerScope.calculation(pageOffset: Float) {
    val fraction = 1f - pageOffset.coerceIn(0f, 1f)
    lerp(start = 0.85f, stop = 1f, fraction = fraction).also { scale -> scaleX = scale; scaleY = scale }
    alpha = lerp(start = 0.5f, stop = 1f, fraction = fraction)
}