package com.example.plugins

import com.example.repository.RegionRepository
import com.example.repository.RegionRepositoryImpl
import com.example.repository.RegionInMemoryRepository
import com.example.service.RegionService
import io.ktor.server.application.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureDependencyInjection() {
    val config = environment.config
    install(Koin) {
        val module = module {
            singleOf(::RegionService)

            val repoMode = config.property("repo").let { RegionRepository.Mode.resolveFromConfig(it.getString()) }
            when (repoMode) {
                RegionRepository.Mode.IN_MEMORY -> singleOf(::RegionInMemoryRepository) { bind<RegionRepository>() }
                RegionRepository.Mode.JDBC -> singleOf(::RegionRepositoryImpl) { bind<RegionRepository>() }
            }

        }
        modules(module)
    }
}
