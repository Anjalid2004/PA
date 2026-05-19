package com.example.myapplicationpa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationpa.data.SampleData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityAlertScreen() {
    var showPanicDialog by remember { mutableStateOf(false) }

    if (showPanicDialog) {
        AlertDialog(
            onDismissRequest = { showPanicDialog = false },
            confirmButton = {
                TextButton(onClick = { showPanicDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Panic Alert") },
            text = { Text("Emergency Alert Sent Successfully. Authorities have been notified.") }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Security Management") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Button(
                onClick = { showPanicDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(Icons.Default.Warning, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text("PANIC BUTTON", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Recent Alerts", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(SampleData.alerts) { alert ->
                    AlertCard(alert.title, alert.description, alert.timestamp, alert.isCritical)
                }
            }
        }
    }
}

@Composable
fun AlertCard(title: String, desc: String, time: String, isCritical: Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (isCritical) Color(0xFFFFEBEE) else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Default.NotificationsActive,
                contentDescription = null,
                tint = if (isCritical) Color.Red else MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = desc, fontSize = 14.sp)
                Text(text = time, fontSize = 12.sp, color = MaterialTheme.colorScheme.outline)
            }
        }
    }
}
