package org.maxkizi.regiondict

import io.ktor.server.application.*
import org.maxkizi.regiondict.plugins.*


fun main(args: Array<String>) {
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureExceptionHandling()
    configureDependencyInjection()
}
