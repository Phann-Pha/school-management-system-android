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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
        fun onNewInstance(activity: Activity, lang: String) : Intent {
            return Intent(activity, SelectingLanguageScreenActivity::class.java)
                    .apply { putExtra(LANGUAGE, lang) }
        }
    }

    private lateinit var activity: Activity
    private val viewmodel: SelectingLanguageScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        activity = this@SelectingLanguageScreenActivity
        super.onCreate(savedInstanceState)
        onChangeIconStatusBarColor(light = true)
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                val raw = intent.extras?.getString(LANGUAGE) ?: "en-US"
                val default = lang.value.collectAsStateWithLifecycle(initialValue = raw).value
                val language = remember { mutableStateOf(value = default?: "en-US") }
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
                        HeaderSelectingLanguageScreen(top = padding.calculateTopPadding()) {
                            finish()
                        }
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 250.dp)
                                .background(color = colorResource(id = R.color.white)),
                            painter = painterResource(id = R.drawable.onboard_3),
                            contentDescription = null
                        )
                        FooterSelectingLanguageScreen(bottom = padding.calculateBottomPadding(), language = language) { status ->
                            onSyncLanguage(status = status)
                        }
                    }
                }
            }
        }
        
        onObservableViewModel()
    }
    
    private fun onSyncLanguage(status: String) {
        viewmodel.onUpdateLanguage(lang = lang, status = status)
    }
    
    private fun onObservableViewModel() {
        viewmodel.uiState.observe(this) {
            startActivity(GetStartingScreenActivity.onNewInstance(activity = activity))
            activity.finish()
        }
    }
}