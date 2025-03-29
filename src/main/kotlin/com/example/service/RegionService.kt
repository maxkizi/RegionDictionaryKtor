package com.example.service

import arrow.core.Either
import com.example.exception.RegionNotFoundError
import com.example.model.Region
import com.example.repository.RegionRepository

class RegionService(private val repo: RegionRepository) {
    fun addRegion(region: Region) = repo.addRegion(region)


    fun findAll(): List<Region> = repo.findAll()

    fun findByRegionCode(regionCode: Int): Either<RegionNotFoundError, Region> =
        repo.findByRegionCode(regionCode)?.let { Either.Right(it) }
            ?: Either.Left(RegionNotFoundError(regionCode = regionCode))

    fun delete(regionCode: Int) = repo.delete(regionCode)

}