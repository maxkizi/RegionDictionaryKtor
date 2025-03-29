package com.example

import com.example.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
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

    @Test
    fun simpleTest() {
        test { a ->
            testFun1()
            "result" + a
        }
    }

    fun test(block: TestClass.(a: String) -> String) {
        println(TestClass().block("fg"))
    }
}
