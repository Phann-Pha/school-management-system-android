package com.domain.visor.school.kh.features.language.presentation.components.header

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.domain.visor.school.kh.R

@Composable
fun HeaderLanguageScreen(top: Dp, backed: () -> Unit)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.white))
            .padding(start = 12.dp, end = 24.dp, top = top)
            .padding(top = 4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) { ButtonBackView(clicked = backed) }
    }
}

@Composable
private fun ButtonBackView(clicked: () -> Unit = {})
{
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.9f else 1f)
    Box(
        modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        FloatingActionButton(
            onClick = { clicked.invoke() },
            modifier = Modifier
                .size(size = 45.dp)
                .scale(scale.value)
                .pointerInteropFilter {
                    when (it.action)
                    {
                        MotionEvent.ACTION_DOWN ->
                        {
                            clicked.invoke()
                            selected.value = true
                        }

                        MotionEvent.ACTION_UP   ->
                        {
                            selected.value = false
                        }
                    }; true
                },
            shape = CircleShape,
            contentColor = colorResource(id = R.color.white),
            containerColor = colorResource(id = R.color.white),
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(size = 24.dp)
                    .rotate(degrees = 180f),
                painter = painterResource(id = R.drawable.icon_round_arrow_right),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = colorResource(id = R.color.black))
            )
        }
    }
}