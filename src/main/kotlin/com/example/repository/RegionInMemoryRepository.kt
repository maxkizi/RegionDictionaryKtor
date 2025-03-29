package com.example.repository

import com.example.model.Region


class RegionInMemoryRepository : RegionRepository {
    private val storage = HashMap<Int, Region>()

    override fun addRegion(region: Region) = storage.let { it[region.regionCode] = region }

    override fun findAll() = storage.values.toList()

    override fun findByRegionCode(regionCode: Int): Region? = storage[regionCode]

    override fun delete(regionCode: Int)  { storage.remove(regionCode) }
}