package com.saltpay.app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltpay.app.domain.model.SongFeed

data class SongFeedDto(
    @SerializedName("author")
    val author: AuthorDto,
    @SerializedName("entry")
    val entry: List<EntryDto>,
    val updated: LabelDto,
    val rights: LabelDto,
    val title: LabelDto,
    val icon: LabelDto,
    val link: List<LinkDto>,
    val id: LabelDto,
)

fun SongFeedDto.toSongFeed(): SongFeed{
    return SongFeed(
        author = author.toAuthor(),
        entry = entry.map { it.toEntry() },
        updated = updated.toLabel(),
        rights = rights.toLabel(),
        title = title.toLabel(),
        icon = icon.toLabel(),
        link = link.map { it.toLink() },
        id = id.toLabel(),
    )
}