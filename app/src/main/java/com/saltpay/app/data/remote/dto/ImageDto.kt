package com.saltpay.app.data.remote.dto

import com.saltpay.app.domain.model.Image


data class ImageDto(
    val label: String,
    val attributes: ImageAttributeDto
)

fun ImageDto.toImage() : Image {
    return Image(
        label = label,
        attributes = attributes.toImageAttribute()
    )
}