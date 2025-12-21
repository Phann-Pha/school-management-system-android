package com.domain.visor.school.kh.features.auth.presentation.components.form

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R


@Composable
fun CustomTextField(value: MutableState<String>, placeholder: String, onValueChange: (String) -> Unit = {})
{
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                border = BorderStroke(width = 0.5.dp, color = colorResource(id = R.color.dark_gray)),
                shape = RoundedCornerShape(size = 16.dp)
            )
            .semantics { contentType = ContentType.Username },
        value = value.value,
        onValueChange = onValueChange,
        label = null,
        singleLine = true,
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.blur_dark_background)
            )
        },
        shape = RoundedCornerShape(size = 16.dp),
        colors = TextFieldDefaults.colors(

            focusedTextColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),

            focusedContainerColor = colorResource(id = R.color.transparent),
            unfocusedContainerColor = colorResource(id = R.color.transparent),

            focusedIndicatorColor = colorResource(id = R.color.transparent),
            unfocusedIndicatorColor = colorResource(id = R.color.transparent),
            disabledIndicatorColor = colorResource(id = R.color.transparent)
        ),
    )
}