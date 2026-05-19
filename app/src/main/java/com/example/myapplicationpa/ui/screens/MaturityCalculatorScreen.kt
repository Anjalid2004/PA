package com.example.myapplicationpa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaturityCalculatorScreen() {
    var age by remember { mutableStateOf("") }
    var girth by remember { mutableStateOf("") }
    var resultReady by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Maturity Calculator") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Estimate your tree's value and readiness for harvest.")

            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Tree Age (Years)") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = girth, onValueChange = { girth = it }, label = { Text("Girth (cm)") }, modifier = Modifier.fillMaxWidth())

            Button(
                onClick = { resultReady = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calculate")
            }

            if (resultReady) {
                val ageVal = age.toDoubleOrNull() ?: 0.0
                val girthVal = girth.toDoubleOrNull() ?: 0.0
                val readiness = (ageVal / 15.0 * 100).coerceAtMost(100.0)
                val estimatedValue = (girthVal * 500) + (ageVal * 2000)

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Results", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Estimated Heartwood: ${String.format("%.1f", readiness)}%")
                        Text(text = "Estimated Value: ₹${String.format("%,.0f", estimatedValue)}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (readiness >= 80) "Ready for harvest!" else "Needs more time to mature.",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}
