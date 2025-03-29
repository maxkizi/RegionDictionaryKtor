package com.example.repository

import com.example.dto.Region


class RegionInMemoryRepository : RegionRepository {
    private val storage = HashMap<Int, Region>()

    override suspend fun addRegion(region: Region) = storage.let { it[region.regionCode] = region }

    override suspend fun findAll() = storage.values.toList()

    override suspend fun findByRegionCode(regionCode: Int): Region? = storage[regionCode]

    override suspend fun delete(regionCode: Int) {
        storage.remove(regionCode)
    }
}