package com.saltpay.app.data.remote.dto

import com.saltpay.app.domain.model.ImageAttribute

data class ImageAttributeDto(
    val height: String
)

fun ImageAttributeDto.toImageAttribute(): ImageAttribute {
    return ImageAttribute(
        height = height
    )
}