package com.androidacademy.fixit.core.data

data class Order(
    val address: Address,
    val dataTime: String,
    val finalPrice: Long,
    val serviceRef: String = "",
    val serviceTargets: List<String>,
    val isCompleted: Boolean,
    val isProcessing: Boolean,
    val userId: String
) {
    data class Address(
        val apartments: Long,
        val building: Long,
        val floor: Long,
        val house: Long,
        val porch: Long,
        val street: String
    )
}