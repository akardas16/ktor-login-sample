package com.login

import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.server.testing.testApplication
import kotlin.test.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Test

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        val response = client.get("/")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Hello World!", response.bodyAsText())
    }

    @Test
    fun testLoginRequest() = testApplication {
        val requestData = "{\n" +
                "    \"email\": \"test@gmail.com\",\n" +
                "    \"password\": \"12345678\"\n" +
                "}"
        val response = client.post("/login") {
            contentType(ContentType.Application.Json)
            setBody(requestData)
        }
        val responseBody = response.bodyAsText()
        assertEquals(HttpStatusCode.OK, response.status)
        assertNotNull(responseBody)
        assertEquals(true, responseBody.contains("id"))
        assertEquals(true, responseBody.contains("email"))
        assertEquals(true, responseBody.contains("test@gmail.com"))
    }
}
