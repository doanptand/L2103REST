package com.ddona.rest.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class FileNotFoundException constructor(message: String) : RuntimeException(message) {
}