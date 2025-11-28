package com.domain.visor.school.kh.features.slashScreen

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R
import com.domain.visor.school.kh.features.language.LanguageActivity

class SlashScreenActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashScreen()
        }

        Handler().postDelayed({
            startActivity(LanguageActivity.newIntent(this))
            finish()
        }, 1500)
    }
}

@Composable
fun SplashScreen() {
    val splashImage = painterResource(id = R.drawable.ic_slash_screen)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(150.dp))

        // Illustration centered
        Image(
            painter = splashImage,
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Version at the bottom
        Text(
            text = "1.0.0",
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(bottom = 32.dp)
        )
    }
}

