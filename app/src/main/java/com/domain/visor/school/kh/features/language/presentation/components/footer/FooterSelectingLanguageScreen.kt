package com.domain.visor.school.kh.features.language.presentation.components.footer

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.language.domain.LanguageStatus
import com.domain.visor.school.kh.features.language.presentation.components.button.SelectingLanguageButton
import com.domain.visor.school.kh.localization.manager.LocalizationDataStore
import com.domain.visor.school.kh.localization.utils.resource

@Composable
fun FooterSelectingLanguageScreen(
    context: Context,
    lang: LocalizationDataStore,
    navigateBottomHeight: Dp,
    language: MutableState<LanguageStatus>,
    clicked: (LanguageStatus) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.white))
            .padding(bottom = navigateBottomHeight)
            .padding(bottom = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.white))
                .padding(bottom = 12.dp),
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
                    text = context.resource(lang).getString(R.string.please_selecting_your_language)
                )

                Spacer(modifier = Modifier.height(height = 24.dp))
                SelectingLanguageButton(
                    context = context,
                    lang = lang,
                    selected = language,
                    clicked = clicked
                )
            }
        }
    }
}