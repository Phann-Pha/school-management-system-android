package com.domain.visor.school.kh.features.onboard.presentation.components.footer

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.onboard.presentation.components.buttons.BoundTextButtonAnimation
import com.domain.visor.school.kh.localization.manager.LocalizationDataStore
import com.domain.visor.school.kh.localization.utils.resource

@Composable
fun FooterGetStartingScreen(
    context: Context,
    lang: LocalizationDataStore,
    navigateBottomHeight: Dp,
    clicked: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.white))
            .padding(bottom = navigateBottomHeight)
            .padding(bottom = 42.dp),
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
                    .fillMaxWidth(fraction = 0.85f)
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
                    text = context.resource(lang).getString(R.string.description_get_starting)
                )
                Spacer(modifier = Modifier.height(height = 32.dp))
                BoundTextButtonAnimation(
                    text = context.resource(lang).getString(R.string.get_started),
                    clicked = clicked
                )
            }
        }
    }
}