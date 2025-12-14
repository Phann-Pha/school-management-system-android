package com.domain.visor.school.kh.features.onboard.presentation.components.header

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R

@Composable
fun HeaderOnboardingScreen(statusBarHeight: Dp, skip: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.white))
            .padding(start = 12.dp, end = 24.dp, top = statusBarHeight)
            .padding(top = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.size(size = 45.dp))
        ButtonSkipView(clicked = skip)
    }
}

@Composable
private fun ButtonSkipView(clicked: () -> Unit = {}) {
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.9f else 1f)
    Box(
        modifier = Modifier
            .scale(scale.value)
            .wrapContentSize()
            .pointerInteropFilter { event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        clicked.invoke()
                        selected.value = true
                    }

                    MotionEvent.ACTION_UP -> {
                        selected.value = false
                    }
                }; true
            }
    ) {
        Text(
            text = stringResource(id = R.string.skip),
            fontSize = 13.sp,
            color = colorResource(id = R.color.black),
            fontWeight = FontWeight.Normal
        )
    }
}