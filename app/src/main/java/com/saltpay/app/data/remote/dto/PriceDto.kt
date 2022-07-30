package com.saltpay.app.data.remote.dto

import com.saltpay.app.domain.model.Price


data class PriceDto(
    val label: String,
    val attributes: PriceAttributeDto
)

fun PriceDto.toPrice(): Price {
    return Price(
        label = label,
        attributes = attributes.toPriceAttribute()
    )
}