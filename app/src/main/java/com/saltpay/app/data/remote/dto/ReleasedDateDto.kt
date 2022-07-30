package com.saltpay.app.data.remote.dto

import com.saltpay.app.domain.model.Category
import com.saltpay.app.domain.model.ReleasedDate

data class ReleasedDateDto(
    val label: String,
    val attributes: LabelDto
)

fun ReleasedDateDto.toReleasedDate(): ReleasedDate {
    return ReleasedDate(
        label = label,
        attributes = attributes.toLabel()
    )
}