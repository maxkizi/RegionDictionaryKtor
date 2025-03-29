package org.maxkizi.regiondict.repository

import org.maxkizi.regiondict.dto.Region
import org.maxkizi.regiondict.orm.RegionDao
import org.maxkizi.regiondict.orm.RegionTable
import org.maxkizi.regiondict.orm.daoToDto
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class RegionRepositoryImpl : RegionRepository {
    override suspend fun addRegion(region: Region) {
        newSuspendedTransaction(Dispatchers.IO) {
            RegionDao.new {
                regionName = region.regionName
                regionCode = EntityID(region.regionCode, RegionTable)
            }
        }
    }

    override suspend fun findAll(): List<Region> = newSuspendedTransaction(Dispatchers.IO) {
        RegionDao.all().map(::daoToDto)
    }


    override suspend fun findByRegionCode(regionCode: Int): Region? =
        newSuspendedTransaction(Dispatchers.IO) {
            RegionDao.findById(regionCode)
        }?.let { Region(it.id.value, it.regionName) }


    override suspend fun delete(regionCode: Int) {
        newSuspendedTransaction(Dispatchers.IO) {
            RegionTable.deleteWhere {
                RegionTable.id eq regionCode
            }
        }
    }
}