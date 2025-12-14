package com.domain.visor.school.kh.features.onboard.presentation.components.buttons

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R

@Composable
fun BoundTextButtonAnimation(text: String, clicked: () -> Unit = {}) {
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.95f else 1f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            colors = ButtonColors(
                contentColor = colorResource(id = R.color.active_dot_indicator),
                containerColor = colorResource(id = R.color.active_dot_indicator),
                disabledContentColor = colorResource(id = R.color.active_dot_indicator),
                disabledContainerColor = colorResource(id = R.color.active_dot_indicator)
            ),
            shape = RoundedCornerShape(size = 12.dp),
            modifier = Modifier
                .scale(scale.value)
                .fillMaxWidth()
                .height(height = 45.dp)
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
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.white)
            )
        }
    }
}