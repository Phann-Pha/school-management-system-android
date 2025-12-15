package com.domain.visor.school.kh.features.language.presentation.components.button

import android.content.Context
import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.domain.visor.school.datastore.LanguageSettingManager
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.share.resource

@Composable
fun SelectingLanguageButton(
    context: Context,
    lang: LanguageSettingManager,
    selected: MutableState<String>,
    clicked: (String) -> Unit = {}
) {

    val khmer = remember { mutableStateOf(value = selected.value == lang.km) }
    val english = remember { mutableStateOf(value = selected.value == lang.en) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonKhmer(
            text = context.resource(lang).getString(R.string.khmer),
            state = khmer,
            clicked = {
                khmer.value = true
                english.value = false
                clicked.invoke(lang.km)
            }
        )
        Spacer(modifier = Modifier.height(height = 8.dp))
        ButtonEnglish(
            text = context.resource(lang).getString(R.string.english),
            state = english,
            clicked = {
                khmer.value = false
                english.value = true
                clicked.invoke(lang.en)
            }
        )
    }
}

@Composable
private fun ButtonKhmer(text: String, state: MutableState<Boolean>, clicked: () -> Unit) {
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.95f else 1f)

    Button(
        onClick = { },
        colors = ButtonColors(
            contentColor = colorResource(id = if (state.value) R.color.active_dot_indicator else R.color.white),
            containerColor = colorResource(id = if (state.value) R.color.active_dot_indicator else R.color.white),
            disabledContentColor = colorResource(id = if (state.value) R.color.active_dot_indicator else R.color.white),
            disabledContainerColor = colorResource(id = if (state.value) R.color.active_dot_indicator else R.color.white)
        ),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier
            .scale(scale.value)
            .fillMaxWidth()
            .wrapContentHeight()
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
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 8.dp),
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = if (state.value) R.color.white else R.color.active_dot_indicator)
        )
    }
}

@Composable
private fun ButtonEnglish(text: String, state: MutableState<Boolean>, clicked: () -> Unit) {
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.95f else 1f)

    Button(
        onClick = { },
        colors = ButtonColors(
            contentColor = colorResource(id = if (state.value) R.color.active_dot_indicator else R.color.white),
            containerColor = colorResource(id = if (state.value) R.color.active_dot_indicator else R.color.white),
            disabledContentColor = colorResource(id = if (state.value) R.color.active_dot_indicator else R.color.white),
            disabledContainerColor = colorResource(id = if (state.value) R.color.active_dot_indicator else R.color.white)
        ),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier
            .scale(scale.value)
            .fillMaxWidth()
            .wrapContentHeight()
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
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 8.dp),
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = if (state.value) R.color.white else R.color.active_dot_indicator)
        )
    }
}