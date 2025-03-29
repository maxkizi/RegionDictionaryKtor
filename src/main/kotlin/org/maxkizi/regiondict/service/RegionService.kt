package org.maxkizi.regiondict.service

import arrow.core.Either
import org.maxkizi.regiondict.exception.RegionNotFoundError
import org.maxkizi.regiondict.dto.Region
import org.maxkizi.regiondict.repository.RegionRepository

class RegionService(private val repo: RegionRepository) {
    suspend fun addRegion(region: Region) = repo.addRegion(region)


    suspend fun findAll(): List<Region> = repo.findAll()

    suspend fun findByRegionCode(regionCode: Int): Either<RegionNotFoundError, Region> =
        repo.findByRegionCode(regionCode)?.let { Either.Right(it) }
            ?: Either.Left(RegionNotFoundError(regionCode = regionCode))

    suspend fun delete(regionCode: Int) = repo.delete(regionCode)

}