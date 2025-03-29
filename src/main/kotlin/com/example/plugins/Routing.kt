package com.example.plugins

import com.example.model.Region
import com.example.service.RegionService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Application.configureRouting() {

    val service: RegionService by inject()
    routing {
        get("/regions") {
            call.respond(
                service.findAll()
            )
        }
        post("/regions") {
            val region = call.receive<Region>()
            service.addRegion(region)
            call.respond(HttpStatusCode.OK)
        }

        get("/regions/{id}") {
            val id = call.parameters["id"]?.toInt() ?: run {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }
            service.findByRegionCode(id)
                .onRight {
                    call.respond(HttpStatusCode.OK, it)
                }
                .onLeft { call.respond(HttpStatusCode.NotFound, it) }
        }

        delete("/regions/{id}") {
            val id = call.parameters["id"]?.toInt() ?: run {
                call.respond(HttpStatusCode.BadRequest)
                return@delete
            }
            service.delete(id)
            call.respond(HttpStatusCode.OK)
        }
    }
}
