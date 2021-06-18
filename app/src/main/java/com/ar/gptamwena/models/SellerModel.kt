package com.ar.gptamwena.models

import java.io.Serializable

data class SellerModel(
    var licenceNumber:String,
    var marketLocation:String,
    var marketName:String,
    var nationalID:String,
    var ownerName:String,
    var phoneNumber:String
    ) : Serializable
