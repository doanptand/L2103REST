package com.ddona.rest.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class StorageException(message: String) : RuntimeException(message) {
}

//{
//    "fileName": "android.apk",
//    "downloadUrl": "http://localhost:8080/downloads/android.apk",
//    "fileType": "application/apk",
//    "fileSize": 34234234
//}