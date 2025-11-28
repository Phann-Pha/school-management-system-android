package com.domain.visor.school.kh.features.onBoard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R

class OnBoardGetStartActivity : ComponentActivity()
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
                ) {
                    OnBoardScreen(
                        onClick = {
                        startActivity(OnBoardFirstActivity.newIntent(this@OnBoardGetStartActivity))
                    })
                }
            }
        }
    }

    companion object {
        fun newIntent(activity: Activity): Intent {
            return Intent(activity, OnBoardGetStartActivity::class.java)
        }
    }
}

@Composable
private fun OnBoardScreen(onClick: () -> Unit) {

    val illustration = painterResource(R.drawable.ic_slash_screen)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Skip",
                color = colorResource(R.color.black),
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.height(90.dp))

        // Illustration
        Image(
            painter = illustration,
            contentDescription = null,
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
        )

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "Your smart solution for fast, accurate attendance tracking. Let’s take a quick tour!",
            color = colorResource(R.color.black),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(80.dp))

        // Khmer Button
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6EDB60)
            )
        ) {
            Text(
                text = "Get start",
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}

