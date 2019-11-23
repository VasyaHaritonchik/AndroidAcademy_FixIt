package com.androidacademy.fixit.core.data

data class ServiceTarget(
    val price: Long,
    val name: String,
    var isSelected: Boolean = false
)