package com.example

import com.example.plugins.configureDependencyInjection
import com.example.plugins.configureExceptionHandling
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.application.*


fun main(args: Array<String>) {
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureExceptionHandling()
    configureDependencyInjection()
}
