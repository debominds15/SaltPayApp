package com.saltpay.app.data.remote.dto

import com.saltpay.app.domain.model.Artist
import com.saltpay.app.domain.model.AttributesArtist
import com.saltpay.app.domain.model.AttributesId

data class ArtistDto(
    val label: String,
    val attributes: AttributesArtistDto?
)

data class AttributesArtistDto(
    val href: String
)

fun ArtistDto.toArtist(): Artist {
    return Artist(
        label = label,
        attributes = attributes?.toAttributesArtist() ?: AttributesArtist("")
    )
}

fun AttributesArtistDto.toAttributesArtist(): AttributesArtist {
    return AttributesArtist(
        href = href
    )
}