package com.example.myapplicationpa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationpa.data.SampleData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrowthTrackerScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Growth Tracker") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Tree Growth Timeline",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(SampleData.growthTimeline) { data ->
                    GrowthItem(data.year, data.girth, data.height)
                }
            }
        }
    }
}

@Composable
fun GrowthItem(year: Int, girth: Double, height: Double) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Year $year", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(text = "Girth", fontSize = 12.sp, color = MaterialTheme.colorScheme.outline)
                    Text(text = "$girth cm", fontWeight = FontWeight.SemiBold)
                }
                Column {
                    Text(text = "Height", fontSize = 12.sp, color = MaterialTheme.colorScheme.outline)
                    Text(text = "$height m", fontWeight = FontWeight.SemiBold)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { (year.toFloat() / 15f).coerceAtMost(1f) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
