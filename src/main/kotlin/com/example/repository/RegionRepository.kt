package com.example.repository

import com.example.dto.Region

interface RegionRepository {
    suspend fun addRegion(region: Region)

    suspend fun findAll(): List<Region>

    suspend fun findByRegionCode(regionCode: Int): Region?

    suspend fun delete(regionCode: Int)
}