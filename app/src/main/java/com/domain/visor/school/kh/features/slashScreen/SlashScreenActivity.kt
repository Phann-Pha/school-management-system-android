package com.domain.visor.school.kh.features.slashScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class SlashScreenActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = ColorBackground
            ) { paddings ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(paddings)
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
//                    ActionBar()
//                    Spacer(modifier = Modifier.height(20.dp))
//                    DailyInfo()
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Attendance()
//                    Spacer(modifier = Modifier.height(20.dp))
//                    WeeklyClass()
                }
            }
        }
    }
}