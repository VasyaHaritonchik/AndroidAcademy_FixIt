package com.androidacademy.fixit.core.data

import com.google.firebase.auth.FirebaseAuth

data class Order(
    val address: Address,
    val dataTime: String,
    val finalPrice: Long,
    val serviceRef: String = "",
    val serviceTargets: List<String>,
    val isCompleted: Boolean = false,
    val isProcessing: Boolean = true,
    val userId: String = FirebaseAuth.getInstance().currentUser?.uid.toString()
)
