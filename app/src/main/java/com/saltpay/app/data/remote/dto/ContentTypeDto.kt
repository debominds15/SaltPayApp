package com.saltpay.app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltpay.app.domain.model.ContentType
import com.saltpay.app.domain.model.ContentType2
import com.saltpay.app.domain.model.PriceAttribute

data class ContentTypeDto(
    @SerializedName("im:contentType")
    val imContentType: ContentType2Dto,
    val attributes: ContentTypeAttributeDto
)

data class ContentType2Dto(
    val attributes: ContentTypeAttributeDto
)

fun ContentTypeDto.toContentType(): ContentType {
    return ContentType(
        imContentType = imContentType.toContentType2(),
        attributes = attributes.toContentTypeAttribute()
    )
}

fun ContentType2Dto.toContentType2(): ContentType2 {
    return ContentType2(
        attributes = attributes.toContentTypeAttribute()
    )
}