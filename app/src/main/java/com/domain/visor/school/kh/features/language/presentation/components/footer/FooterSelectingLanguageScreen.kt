package com.domain.visor.school.kh.features.language.presentation.components.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.language.presentation.components.button.SelectingLanguageButton

@Composable
fun FooterSelectingLanguageScreen(bottom: Dp, language: MutableState<String>, clicked: (String) -> Unit = {})
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.white))
            .padding(bottom = bottom)
            .padding(bottom = 26.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.8f)
                    .background(color = colorResource(id = R.color.white)),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.transparent))
                        .padding(vertical = 4.dp),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp,
                    softWrap = true,
                    text = stringResource(id = R.string.please_selecting_your_language)
                )

                Spacer(modifier = Modifier.height(height = 24.dp))
                SelectingLanguageButton(selected = language, clicked = clicked)
            }
        }
    }
}