package com.saltpay.app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltpay.app.domain.model.AttributesId
import com.saltpay.app.domain.model.EntryId

data class EntryIdDto(
    val label: String,
    val attributes: AttributesIdDto
)

data class AttributesIdDto(
    @SerializedName("im:id")
    val imId: String
)

fun EntryIdDto.toEntryId(): EntryId {
    return EntryId(
        label = label,
        attributes = attributes.toAttributesId()
    )
}

fun AttributesIdDto.toAttributesId(): AttributesId {
    return AttributesId(
        imId = imId
    )
}