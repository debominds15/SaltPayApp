package com.saltpay.app.data.remote.dto

import com.saltpay.app.domain.model.ContentTypeAttribute

data class ContentTypeAttributeDto(
    val term: String,
    val label: String,
)

fun ContentTypeAttributeDto.toContentTypeAttribute(): ContentTypeAttribute {
    return ContentTypeAttribute(
        term = term,
        label = label
    )
}