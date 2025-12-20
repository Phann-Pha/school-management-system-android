package com.domain.visor.school.kh.features.auth.presentation.components.footer

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R

@Composable
fun FooterLoginScreen(
    bottom: Dp,
    clickLogin: () -> Unit = {},
    forgetPassClick: () -> Unit = {}
)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.65f)
                .wrapContentHeight()
                .padding(bottom = bottom),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ButtonLogin(
                text = stringResource(id = R.string.login),
                clicked = clickLogin
            )
            Spacer(modifier = Modifier.height(height = 12.dp))
            ButtonForgetPassword(
                text = stringResource(id = R.string.forget_password),
                clicked = forgetPassClick
            )
        }
    }
}

@Composable
private fun ButtonLogin(text: String, clicked: () -> Unit)
{
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.95f else 1f)

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
            .wrapContentHeight()
            .pointerInteropFilter { event ->
                when (event.action)
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
            }
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 8.dp),
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.white)
        )
    }
}

@Composable
private fun ButtonForgetPassword(text: String, clicked: () -> Unit)
{
    val selected = remember { mutableStateOf(value = false) }
    val scale = animateFloatAsState(targetValue = if (selected.value) 0.95f else 1f)

    Button(
        onClick = { },
        colors = ButtonColors(
            contentColor = colorResource(id = R.color.white),
            containerColor = colorResource(id = R.color.white),
            disabledContentColor = colorResource(id = R.color.white),
            disabledContainerColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier
            .scale(scale.value)
            .fillMaxWidth()
            .wrapContentHeight()
            .pointerInteropFilter { event ->
                when (event.action)
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
            }
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 8.dp),
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.active_dot_indicator)
        )
    }
}