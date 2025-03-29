package com.example.orm

import com.example.dto.Region
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object RegionTable : IntIdTable("regions", "region_code") {
    val regionName = text("region_name")
}

class RegionDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RegionDao>(RegionTable)

    var regionName by RegionTable.regionName
    var regionCode by RegionTable.id
}



fun daoToDto(dao: RegionDao) = Region(dao.regionCode.value, dao.regionName)