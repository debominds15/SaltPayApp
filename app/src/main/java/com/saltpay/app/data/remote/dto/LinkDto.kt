package com.saltpay.app.data.remote.dto

import com.saltpay.app.domain.model.Attributes
import com.saltpay.app.domain.model.Link

data class LinkDto(
    val attributes: AttributesDto?
)

data class AttributesDto(
    val rel: String,
    val type: String,
    val href: String,
)

fun LinkDto.toLink(): Link{
    return Link(
        attributes = attributes?.toAttributes() ?: Attributes("", "", "")
    )
}

fun AttributesDto.toAttributes(): Attributes{
    return Attributes(
        rel = rel,
        type = type,
        href = href
    )
}