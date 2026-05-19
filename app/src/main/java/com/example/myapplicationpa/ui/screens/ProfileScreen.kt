package com.example.myapplicationpa.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Profile") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(60.dp), tint = MaterialTheme.colorScheme.primary)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Sadananda Farmer", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Village: Shimoga, Karnataka", fontSize = 16.sp, color = MaterialTheme.colorScheme.outline)

            Spacer(modifier = Modifier.height(32.dp))

            ProfileOption("My Trees", "124 Trees", Icons.Default.Person)
            ProfileOption("Settings", "App preferences", Icons.Default.Settings)
            ProfileOption("About Gandha-Siri", "Version 1.0", Icons.Default.Info)

            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Logged in as Farmer", fontSize = 12.sp, color = MaterialTheme.colorScheme.outline)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProfileOption(title: String, subtitle: String, icon: ImageVector) {
    Surface(
        onClick = { },
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.SemiBold)
                Text(text = subtitle, fontSize = 12.sp, color = MaterialTheme.colorScheme.outline)
            }
            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = MaterialTheme.colorScheme.outline)
        }
    }
}
