package org.maxkizi.regiondict.dto

import kotlinx.serialization.Serializable

@Serializable
data class Region(
    val regionCode: Int,
    val regionName: String
)