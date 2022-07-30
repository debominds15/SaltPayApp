package com.saltpay.app.data.remote.dto

import com.saltpay.app.domain.model.PriceAttribute

data class PriceAttributeDto(
    val amount: String,
    val currency: String,
)

fun PriceAttributeDto.toPriceAttribute(): PriceAttribute {
    return PriceAttribute(
        amount = amount,
        currency = currency
    )
}