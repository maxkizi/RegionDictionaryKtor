package com.example

import com.example.plugins.configureExceptionHandling
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import com.example.repository.RegionInMemoryRepository
import com.example.service.RegionService
import io.ktor.server.application.*
import io.ktor.server.netty.*


fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    val service = RegionService(RegionInMemoryRepository())
    configureSerialization()
    configureRouting(service)
    configureExceptionHandling()
}
