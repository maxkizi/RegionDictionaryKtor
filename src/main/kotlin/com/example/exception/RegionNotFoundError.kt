package com.example.exception

import kotlinx.serialization.Serializable

@Serializable
data class RegionNotFoundError (val message: String = "Region not found", val regionCode: Int)