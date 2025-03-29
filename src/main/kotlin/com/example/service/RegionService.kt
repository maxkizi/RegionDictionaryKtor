package com.example.service

import arrow.core.Either
import com.example.exception.RegionNotFoundError
import com.example.dto.Region
import com.example.repository.RegionRepository

class RegionService(private val repo: RegionRepository) {
    suspend fun addRegion(region: Region) = repo.addRegion(region)


    suspend fun findAll(): List<Region> = repo.findAll()

    suspend fun findByRegionCode(regionCode: Int): Either<RegionNotFoundError, Region> =
        repo.findByRegionCode(regionCode)?.let { Either.Right(it) }
            ?: Either.Left(RegionNotFoundError(regionCode = regionCode))

    suspend fun delete(regionCode: Int) = repo.delete(regionCode)

}