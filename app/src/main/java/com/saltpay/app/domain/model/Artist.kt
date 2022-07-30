package com.saltpay.app.domain.model

data class Artist(
    val label: String,
    val attributes: AttributesArtist
)

data class AttributesArtist(
    val href: String
)