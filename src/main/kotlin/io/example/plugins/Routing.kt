package io.example.plugins

import io.example.api.Health
import io.example.api.Health.getHealthStatus
import io.example.dto.HealthDTOInterface
import io.github.smiley4.ktorswaggerui.dsl.get
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.http.*
import io.ktor.server.application.*
import kotlinx.serialization.json.JsonNull.content

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        getHealthStatus {
            call.respond(HealthDTOInterface.HealthDTO(uptime = 0, database = true))
        }
    }
}
