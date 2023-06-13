package io.example.plugins

import io.ktor.server.application.*

import io.github.smiley4.ktorswaggerui.SwaggerUI
import io.github.smiley4.ktorswaggerui.dsl.AuthScheme
import io.github.smiley4.ktorswaggerui.dsl.AuthType
import io.github.smiley4.ktorswaggerui.dsl.SwaggerUiSort
import io.github.smiley4.ktorswaggerui.dsl.SwaggerUiSyntaxHighlight


fun Application.configureSwagger() {
    install(SwaggerUI) {
        swagger {
            forwardRoot = true
            swaggerUrl = "docs"
            displayOperationId = true
            showTagFilterInput = true
            sort = SwaggerUiSort.HTTP_METHOD
            syntaxHighlight = SwaggerUiSyntaxHighlight.OBSIDIAN
        }

        info {
            title = "Example of api using ktor and swagger"
            version = "1.0.0"
            description = "This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/)."
            termsOfService = "http://swagger.io/terms/"
            contact {
                name = "API Support"
                url = "http://www.swagger.io/support"
                email = "email@teste.com"
            }
            license {
                name = "Apache 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.html"
            }
        }

        server {
            url = "http://localhost:8080"
            description = "Local server"
        }

        server {
            url = "http://example.caju.k8s.stag.in"
            description = "Staging server"
        }

        server {
            url = "http://example.caju.k8s.prod.in"
            description = "Production server"
        }

        securityScheme("basicAuth") {
            type = AuthType.HTTP
            scheme = AuthScheme.BASIC
        }

    }
}