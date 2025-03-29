package com.example

import com.example.plugins.configureDependencyInjection
import com.example.plugins.configureExceptionHandling
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*


fun main(args: Array<String>) = EngineMain.main(args)

fun Application.regionDictApp() {
    configureSerialization()
    configureRouting()
    configureExceptionHandling()
    configureDependencyInjection()
}
