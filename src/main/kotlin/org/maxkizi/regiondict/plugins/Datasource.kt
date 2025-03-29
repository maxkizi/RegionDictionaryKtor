package org.maxkizi.regiondict.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatasource() {
    val config = environment.config
    Database.connect(
        HikariDataSource(HikariConfig().apply {
            jdbcUrl = config.property("datasource.url").getString()
            username = config.property("datasource.username").getString()
            password = config.property("datasource.password").getString()
            maximumPoolSize = 10
        })
    )
}