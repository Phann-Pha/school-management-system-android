package com.domain.visor.school.kh.features.onboard.presentation.components.buttons

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.domain.visor.school.kh.R

@Composable
fun BoundIconButtonAnimation(clicked: () -> Unit = {})
{
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.85f else 1f)
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(all = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        FloatingActionButton(
            onClick = { },
            modifier = Modifier
                .size(size = 56.dp)
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
            shape = RoundedCornerShape(corner = CornerSize(size = 18.dp)),
            contentColor = colorResource(id = R.color.white),
            containerColor = colorResource(id = R.color.active_dot_indicator),
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 2.dp)
        ) {
            Image(
                modifier = Modifier.size(size = 30.dp),
                painter = painterResource(id = R.drawable.icon_round_arrow_right),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = colorResource(id = R.color.white))
            )
        }
    }
}
