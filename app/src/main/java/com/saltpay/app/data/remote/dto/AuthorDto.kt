package com.saltpay.app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltpay.app.domain.model.Author

data class AuthorDto (
    @SerializedName("name")
    val name: LabelDto,
    @SerializedName("uri")
    val uri: LabelDto
)

fun AuthorDto.toAuthor() = Author(
    name = name.toLabel(),
    uri = uri.toLabel()
)