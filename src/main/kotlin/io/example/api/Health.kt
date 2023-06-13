package io.example.api
import io.example.dto.ErrorResponse
import io.example.dto.HealthDTOInterface
import io.github.smiley4.ktorswaggerui.dsl.get
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

object Health {
    fun Route.getHealthStatus (logicBlock: suspend PipelineContext<Unit, ApplicationCall>.() -> Unit) =
        get("/health", {
        tags = listOf("health")
        description = "Health check"
            request {
            queryParameter<Boolean>("checkDatabase") {
                description = "Check database connection"
                required = false
            }
        }
        response {
            HttpStatusCode.OK to  {
                body<HealthDTOInterface>() {
                    example("Example 1",HealthDTOInterface.HealthDTO(uptime = 0, database = true))
                    example("Example 2",HealthDTOInterface.healthDTO2(uptime = 0))
                }
            }
            HttpStatusCode.InternalServerError to  {
                body<ErrorResponse>() {
                    example("Example 1",ErrorResponse(message = "Internal server error", code = 500))
                }
            }
        }
    }) {
        logicBlock()
    }
}