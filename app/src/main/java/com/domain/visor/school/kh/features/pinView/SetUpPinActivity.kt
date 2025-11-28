package com.domain.visor.school.kh.features.pinView

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R

class SetUpPinActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetPinScreen()
        }
    }

    companion object {
        fun newIntent(activity: Activity): Intent {
            return Intent(activity, SetUpPinActivity::class.java)
        }
    }
}

@Composable
fun SetPinScreen(
    pin: String = "",
    onPinChange: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {
    val maxPin = 4

    Scaffold(
        containerColor = colorResource(R.color.white),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(26.dp)
                        .clickable { onBack() }
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            // ICON
            Image(
                painter = painterResource(id = R.drawable.ic_slash_screen),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Set PIN",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(28.dp))

            // PIN BOXES
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                repeat(maxPin) { index ->
                    val isFilled = index < pin.length
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .border(
                                width = if (index == pin.length) 2.dp else 1.dp,
                                color = if (index == pin.length) Color(0xFF4CAF50) else Color(0xFFE0E0E0),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isFilled) {
                            Text(text = "•", fontSize = 28.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // KEYPAD
            Column(
                modifier = Modifier.width(260.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                val keypad = listOf(
                    listOf("1", "2", "3"),
                    listOf("4", "5", "6"),
                    listOf("7", "8", "9"),
                )

                keypad.forEach { row ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        /*row.forEach { number ->
                            NumberKey(
                                label = number,
                                onClick = {
                                    if (pin.length < maxPin) onPinChange(pin + number)
                                }
                            )
                        }*/
                        row.forEach { item ->
                            when (item) {
                                "" -> EmptyKey() // <-- replaces Spacer, keeps everything centered
                                "del" -> DeleteKey { if (pin.isNotEmpty()) onPinChange(pin.dropLast(1)) }
                                else -> NumberKey(item) {
                                    if (pin.length < 4) onPinChange(pin + item)
                                }
                            }
                        }
                    }
                }

                // LAST ROW (0 + delete)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(72.dp)) // empty space alignment

                    NumberKey(
                        label = "0",
                        onClick = {
                            if (pin.length < maxPin) onPinChange(pin + "0")
                        }
                    )

                    DeleteKey(
                        onDelete = {
                            if (pin.isNotEmpty()) onPinChange(pin.dropLast(1))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NumberKey(label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(Color(0xFFF3F3F3))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(label, fontSize = 24.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun DeleteKey(onDelete: () -> Unit) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(Color(0xFFF3F3F3))
            .clickable { onDelete() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Delete",
            modifier = Modifier.size(26.dp),
            tint = Color(0xFF9E9E9E)
        )
    }
}

@Composable
fun EmptyKey() {
    Box(
        modifier = Modifier
            .size(72.dp)
            .background(Color.Transparent)
    )
}

