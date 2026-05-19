package com.example.myapplicationpa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationpa.data.SampleData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onAddTreeClick: () -> Unit, onTreeClick: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gandha-Siri Dashboard") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddTreeClick, containerColor = MaterialTheme.colorScheme.primary) {
                Icon(Icons.Default.Add, contentDescription = "Add Tree")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Welcome, Farmer!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            val stats = listOf(
                DashboardStat("Total Trees", "124", Icons.Default.Eco),
                DashboardStat("Healthy", "118", Icons.Default.HealthAndSafety),
                DashboardStat("Alerts", "2", Icons.Default.Security),
                DashboardStat("Growth", "+12%", Icons.Default.TrendingUp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.height(240.dp)
            ) {
                items(stats) { stat ->
                    StatCard(stat)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Recent Trees",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(SampleData.trees.size) { index ->
                    val tree = SampleData.trees[index]
                    TreeListItem(tree.name, "ID: ${tree.id}", onClick = { onTreeClick(tree.id) })
                }
            }
        }
    }
}

data class DashboardStat(val label: String, val value: String, val icon: ImageVector)

@Composable
fun StatCard(stat: DashboardStat) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(stat.icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            Text(text = stat.value, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = stat.label, fontSize = 12.sp)
        }
    }
}

@Composable
fun TreeListItem(title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Eco, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = subtitle, fontSize = 12.sp, color = MaterialTheme.colorScheme.outline)
            }
        }
    }
}
