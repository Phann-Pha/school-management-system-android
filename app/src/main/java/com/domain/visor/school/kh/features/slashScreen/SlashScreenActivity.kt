package com.domain.visor.school.kh.features.slashScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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

class SlashScreenActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = colorResource(R.color.white)
            ) { paddings ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(paddings)
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    SlashScreen()
                }
            }
        }
    }
}

@Composable
fun SlashScreen() {
    val image = painterResource(id = R.drawable.ic_slash_screen)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(60.dp))

        // Illustration
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "1.0.0",
            color = Color(0xFF2E8B57),
            fontSize = 16.sp
        )
    }
}
