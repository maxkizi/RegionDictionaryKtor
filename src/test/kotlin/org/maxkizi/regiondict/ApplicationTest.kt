package org.maxkizi.regiondict


import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        /*    application {
                configureRouting()
            }
            client.get("/").apply {
                assertEquals(HttpStatusCode.OK, status)
                assertEquals("Hello World!", bodyAsText())
            }*/
    }
}
