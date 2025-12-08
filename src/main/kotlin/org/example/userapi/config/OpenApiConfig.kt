package org.example.userapi.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig(
    @Value("\${app.version}") private val appVersion: String,
) {

    @Bean
    fun apiInfo(): OpenAPI = OpenAPI().info(
        Info()
            .title("User API")
            .description("A description text for this awesome API goes here...")
            .version(appVersion)
    )

}