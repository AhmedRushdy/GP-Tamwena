package com.ar.gptamwena.models

data class TransactionModel(
    var customerId: String,
    var sellerId: String,
    var totalCost: String,
    var transactionDate: String,
    val transactionId: String
)
