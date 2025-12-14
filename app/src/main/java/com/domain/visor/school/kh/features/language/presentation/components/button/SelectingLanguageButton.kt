package com.domain.visor.school.kh.features.language.presentation.components.button

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R

@Composable
fun SelectingLanguageButton(clicked: () -> Unit = {}) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonView(
            text = stringResource(id = R.string.khmer),
            isDefault = true,
            defaultColor = colorResource(id = R.color.active_dot_indicator),
            clicked = clicked
        )
        Spacer(modifier = Modifier.height(height = 12.dp))
        ButtonView(
            text = stringResource(id = R.string.english),
            isDefault = false,
            defaultColor = colorResource(id = R.color.white),
            clicked = clicked
        )
    }
}

@Composable
private fun ButtonView(text: String, isDefault: Boolean = false, defaultColor: Color, clicked: () -> Unit) {
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.95f else 1f)

    Button(
        onClick = { },
        colors = ButtonColors(
            contentColor = if (isDefault) defaultColor else colorResource(id = R.color.white),
            containerColor = if (isDefault) defaultColor else colorResource(id = R.color.white),
            disabledContentColor = if (isDefault) defaultColor else colorResource(id = R.color.white),
            disabledContainerColor = if (isDefault) defaultColor else colorResource(id = R.color.white)
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
            fontWeight = FontWeight.Medium,
            color = if (isDefault) colorResource(id = R.color.white) else colorResource(id = R.color.active_dot_indicator)
        )
    }
}