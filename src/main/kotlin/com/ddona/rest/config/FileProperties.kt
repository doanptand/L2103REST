package com.ddona.rest.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "file")
class FileProperties {
    lateinit var uploadDir: String
}