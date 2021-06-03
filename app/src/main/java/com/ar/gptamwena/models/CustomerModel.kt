package com.ar.gptamwena.models

import java.io.Serializable

class CustomerModel(
    var cID: String,
    var cName: String,
    var cLocation: String,
    var cardNumber: String,
    var phoneNumber: String,
    var wallet: String,
    var familyNums: String,
    var password: String,
    var transID: String

):Serializable
