package com.example.myapplicationpa.data

data class Tree(
    val id: String,
    val name: String,
    val age: Int,
    val girth: Double,
    val healthStatus: String,
    val heartwoodReadiness: Double, // Percentage
    val securityLevel: String,
    val location: String
)

data class SecurityAlert(
    val id: String,
    val title: String,
    val description: String,
    val timestamp: String,
    val isCritical: Boolean
)

data class GrowthData(
    val year: Int,
    val girth: Double,
    val height: Double
)

object SampleData {
    val trees = listOf(
        Tree("T001", "Sandalwood Alpha", 5, 25.4, "Healthy", 45.0, "High", "North Plot"),
        Tree("T002", "Sandalwood Beta", 3, 15.2, "Excellent", 20.0, "Medium", "South Plot"),
        Tree("T003", "Sandalwood Gamma", 10, 55.0, "Fair", 85.0, "High", "East Plot")
    )

    val alerts = listOf(
        SecurityAlert("A1", "Motion Detected", "Unusual activity near North Plot", "10:30 AM", true),
        SecurityAlert("A2", "Gate Opened", "Main entrance gate opened", "08:15 AM", false)
    )

    val growthTimeline = listOf(
        GrowthData(1, 5.0, 1.2),
        GrowthData(3, 15.0, 3.5),
        GrowthData(5, 25.0, 6.0),
        GrowthData(10, 55.0, 12.0)
    )
}
