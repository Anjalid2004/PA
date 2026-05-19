package com.example.myapplicationpa.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreeRegisterScreen(onBack: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var girth by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Register New Tree") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.LightGray, shape = MaterialTheme.shapes.medium),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.PhotoCamera,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                    Text("Add Photo", style = MaterialTheme.typography.labelSmall)
                }
            }

            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Tree Name") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = id, onValueChange = { id = it }, label = { Text("Tree ID") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age (Years)") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = girth, onValueChange = { girth = it }, label = { Text("Girth (cm)") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("Location") }, modifier = Modifier.fillMaxWidth())

            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Tree Registered Successfully")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Save Tree")
            }
        }
    }
}
