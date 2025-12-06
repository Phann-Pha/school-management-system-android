package com.domain.visor.school.kh.features.homeScreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.visor.school.kh.R

class HomeScreenActivity : ComponentActivity()
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
                        .padding(16.dp)
                ) {
                    HomeScreen()
                }
            }
        }
    }

    companion object {
        fun onInstance(activity: Activity) = Intent(activity, HomeScreenActivity::class.java)
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // --- Header ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Hello, Sothea",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF4F4F4)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification_96),
                    contentDescription = null,
                    tint = Color.Black.copy(alpha = 0.8f),
                    modifier = Modifier.size(26.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Banner Slider ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_banner),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Two Stat Cards ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Use weight so both cards are equal width
            StatCardWithIcon(
                modifier = Modifier.weight(1f),
                title = "Management",
                value = "168",
                bgColor = Color(0xFFF3CFC1),
                tintColor = R.color.dark_pink,
                topRightIconRes = R.drawable.ic_time_90 // replace with your small icon
            )

            StatCardWithIcon(
                modifier = Modifier.weight(1f),
                title = "Attendance",
                value = "45",
                subText = "Students",
                bgColor = Color(0xFFDFF0C8),
                tintColor = R.color.dark_green,
                topRightIconRes = R.drawable.ic_management_96 // replace with your small icon
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Bottom Menu Cards ---
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFFF5F5F7))
                .padding(vertical = 16.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(6.dp))

            MenuLargeCard(
                icon = R.drawable.ic_management_96,
                title = "Admin & Security",
                tintColor = R.color.dark_green
            )

            MenuLargeCard(
                icon = R.drawable.ic_management_96,
                title = "Subject Management",
                tintColor = R.color.dark_green
            )

            Spacer(modifier = Modifier.width(6.dp))
        }
    }
}

// ----------- Reusable Composables ----------- //

@Composable
fun StatCardWithIcon(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    subText: String = "",
    bgColor: Color,
    tintColor: Int,
    topRightIconRes: Int
) {
    Box(
        modifier = modifier
            .height(165.dp) // fixed height to match screenshot
            .clip(RoundedCornerShape(30.dp))
            .background(bgColor)
            .padding(16.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            // Title top-left
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )

                // Small circular icon at top-right (white circular background like screenshot)
                Icon(
                    painter = painterResource(id = topRightIconRes),
                    contentDescription = null,
                    tint = colorResource(tintColor),
                    modifier = Modifier.size(18.dp)
                )
            }

            Text(
                text = value,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(text = subText, fontSize = 14.sp)
        }
    }
}

@Composable
fun MenuLargeCard(icon: Int, tintColor: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFFD9E7B7))
            .padding(horizontal = 20.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = colorResource(tintColor),
            modifier = Modifier.size(30.dp)
        )

        Spacer(modifier = Modifier.width(14.dp))

        Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Medium)
    }
}

