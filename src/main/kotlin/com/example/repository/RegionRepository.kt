package com.example.repository

import com.example.model.Region

interface RegionRepository {
    fun addRegion(region: Region)

    fun findAll(): List<Region>

    fun findByRegionCode(regionCode: Int): Region?

    fun delete(regionCode: Int)
}