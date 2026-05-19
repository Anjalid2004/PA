package com.example.myapplicationpa.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Forest
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationpa.data.SampleData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreeDetailsScreen(treeId: String?, onBack: () -> Unit, onViewGrowthClick: () -> Unit) {
    val tree = SampleData.trees.find { it.id == treeId } ?: SampleData.trees[0]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tree Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant, shape = MaterialTheme.shapes.medium),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Forest, contentDescription = null, modifier = Modifier.size(100.dp), tint = MaterialTheme.colorScheme.primary)
            }

            Text(text = tree.name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text(text = "ID: ${tree.id}", fontSize = 16.sp, color = MaterialTheme.colorScheme.outline)

            HorizontalDivider()

            DetailRow("Age", "${tree.age} Years")
            DetailRow("Girth", "${tree.girth} cm")
            DetailRow("Health Status", tree.healthStatus)
            DetailRow("Location", tree.location)
            DetailRow("Security Level", tree.securityLevel)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Heartwood Readiness", fontWeight = FontWeight.SemiBold)
            LinearProgressIndicator(
                progress = { tree.heartwoodReadiness.toFloat() / 100f },
                modifier = Modifier.fillMaxWidth().height(8.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
            Text(text = "${tree.heartwoodReadiness}% Ready", fontSize = 14.sp, modifier = Modifier.align(Alignment.End))

            Spacer(modifier = Modifier.height(24.dp))
            
            Button(onClick = onViewGrowthClick, modifier = Modifier.fillMaxWidth()) {
                Text("View Growth History")
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = MaterialTheme.colorScheme.outline)
        Text(text = value, fontWeight = FontWeight.Bold)
    }
}
