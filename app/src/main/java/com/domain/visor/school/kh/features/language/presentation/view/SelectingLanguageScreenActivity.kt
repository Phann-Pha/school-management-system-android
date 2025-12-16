package com.domain.visor.school.kh.features.language.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.domain.visor.school.datastore.LanguageHelper
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.base.BaseComponentActivity
import com.domain.visor.school.kh.features.language.presentation.components.footer.FooterSelectingLanguageScreen
import com.domain.visor.school.kh.features.language.presentation.components.header.HeaderSelectingLanguageScreen
import com.domain.visor.school.kh.features.language.presentation.viewmodel.SelectingLanguageScreenViewModel
import com.domain.visor.school.kh.features.onboard.presentation.view.GetStartingScreenActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectingLanguageScreenActivity : BaseComponentActivity() {

    companion object {
        private const val LANGUAGE = "language"
        fun onNewInstance(activity: Activity, lang: String): Intent {
            return Intent(activity, SelectingLanguageScreenActivity::class.java)
                .apply { putExtra(LANGUAGE, lang) }
        }
    }

    private lateinit var activity: Activity
    private val viewmodel: SelectingLanguageScreenViewModel by viewModels()

    private val languageHelper by lazy { LanguageHelper() }

    override fun onCreate(savedInstanceState: Bundle?) {
        activity = this@SelectingLanguageScreenActivity
        super.onCreate(savedInstanceState)
        onChangeIconStatusBarColor(light = true)
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->

                val currentLanguageCode: String = languageHelper.getLanguageCode(context = activity)
                var currentLanguage: String by remember { mutableStateOf(value = currentLanguageCode) }

                val onCurrentLanguageCode: (String) -> Unit = { code ->
                    currentLanguage = code
                    languageHelper.changeLanguage(context = activity, languageCode = code)
                    viewmodel.onUpdateLanguage(code = code)
                }

                val language = remember { mutableStateOf(value = currentLanguage) }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.white)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        HeaderSelectingLanguageScreen(top = padding.calculateTopPadding()) { finish() }
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 250.dp)
                                .background(color = colorResource(id = R.color.white)),
                            painter = painterResource(id = R.drawable.onboard_3),
                            contentDescription = null
                        )
                        FooterSelectingLanguageScreen(bottom = padding.calculateBottomPadding(), language = language) { status ->
                            onCurrentLanguageCode.invoke(status)
                        }
                    }
                }
            }
        }

        onObservableViewModel()
    }

    private fun onObservableViewModel() {
        viewmodel.uiState.observe(this) {
            startActivity(GetStartingScreenActivity.onNewInstance(activity = activity))
            activity.finish()
        }
    }
}