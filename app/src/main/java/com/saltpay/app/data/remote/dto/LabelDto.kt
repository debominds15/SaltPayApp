package com.saltpay.app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltpay.app.domain.model.Label

data class LabelDto(
    @SerializedName("label")
    val label: String
)

fun LabelDto.toLabel(): Label{
    return Label(
        label = label
    )
}