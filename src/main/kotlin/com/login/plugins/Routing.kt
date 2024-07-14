package com.login.plugins

import com.login.model.LoginRequestData
import com.login.model.LoginResponseData
import com.login.model.ResponseModel
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import kotlin.random.Random


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        post("/login") {
            val data = call.receive<LoginRequestData>()
            // TODO Verify email/password
            val randomId = Random.nextInt().toString()
            call.respond(HttpStatusCode.OK, LoginResponseData(randomId, data.email))
        }

        get("/hello") {
            call.respond(HttpStatusCode.OK, ResponseModel(message = "Heey how are you?"))
        }
    }
}
