package com.example.plugins

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/region_dict",
        user = "postgres",
        password = "postgres"
    )
}