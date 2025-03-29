package org.maxkizi.regiondict.plugins

import org.maxkizi.regiondict.repository.RegionRepository
import org.maxkizi.regiondict.repository.RegionRepositoryImpl
import org.maxkizi.regiondict.repository.RegionInMemoryRepository
import org.maxkizi.regiondict.service.RegionService
import io.ktor.server.application.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureDependencyInjection() {
    val config = environment.config
    val serviceBean = module {
        singleOf(::RegionService)
    }

    val repoBeans = module {
        val repoMode = config.property("repo").let { RegionRepository.Mode.resolveFromConfig(it.getString()) }
        when (repoMode) {
            RegionRepository.Mode.IN_MEMORY -> singleOf(::RegionInMemoryRepository) { bind<RegionRepository>() }
            RegionRepository.Mode.JDBC -> singleOf(::RegionRepositoryImpl) { bind<RegionRepository>() }
        }
    }

    install(Koin) {
        modules(serviceBean, repoBeans)
    }
}
