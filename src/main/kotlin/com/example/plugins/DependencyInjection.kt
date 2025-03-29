package com.example.plugins

import com.example.repository.RegionInMemoryRepository
import com.example.repository.RegionRepository
import com.example.service.RegionService
import io.ktor.server.application.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureDependencyInjection() {
    install(Koin) {
        val module = module {
            singleOf(::RegionService)
            singleOf(::RegionInMemoryRepository){bind<RegionRepository>()}
        }
        modules(module)
    }
}
