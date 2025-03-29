package com.example.repository

import com.example.dto.Region

interface RegionRepository {
    enum class Mode(val configValue: String) {
        IN_MEMORY("in-memory"), JDBC("jdbc");

        companion object {
            fun resolveFromConfig(configValue: String): Mode =
                entries.find { it.configValue == configValue }
                    ?: throw IllegalArgumentException("Could not resolve RegionRepository.Mode by configValue: $configValue")
        }
    }

    suspend fun addRegion(region: Region)

    suspend fun findAll(): List<Region>

    suspend fun findByRegionCode(regionCode: Int): Region?

    suspend fun delete(regionCode: Int)
}