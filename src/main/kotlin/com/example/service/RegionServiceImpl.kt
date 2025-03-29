package com.example.service

import arrow.core.Either
import com.example.exception.RegionNotFoundError
import com.example.model.Region
import com.example.repository.RegionRepository

interface RegionService {
    fun addRegion(region: Region)
    fun findAll(): List<Region>
    fun findByRegionCode(regionCode: Int): Either<RegionNotFoundError, Region>
    fun delete(regionCode: Int)
}

class RegionServiceImpl(private val repo: RegionRepository) : RegionService {
    override fun addRegion(region: Region) = repo.addRegion(region)


    override fun findAll(): List<Region> = repo.findAll()

    override fun findByRegionCode(regionCode: Int): Either<RegionNotFoundError, Region> =
        repo.findByRegionCode(regionCode)?.let { Either.Right(it) }
            ?: Either.Left(RegionNotFoundError(regionCode = regionCode))

    override fun delete(regionCode: Int) = repo.delete(regionCode)

}