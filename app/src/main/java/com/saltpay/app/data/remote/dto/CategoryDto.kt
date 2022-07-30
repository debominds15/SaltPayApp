package com.saltpay.app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltpay.app.domain.model.Artist
import com.saltpay.app.domain.model.AttributesArtist
import com.saltpay.app.domain.model.AttributesCategory
import com.saltpay.app.domain.model.Category

data class CategoryDto(
    val attributes: AttributesCategoryDto
)

data class AttributesCategoryDto(
    @SerializedName("im:id")
    val imId: String,
    val term: String,
    val scheme: String,
    val label: String,
)

fun CategoryDto.toCategory(): Category {
    return Category(
        attributes = attributes.toAttributesCategory()
    )
}

fun AttributesCategoryDto.toAttributesCategory(): AttributesCategory {
    return AttributesCategory(
        imId = imId,
        term = term,
        scheme = scheme,
        label = label
    )
}