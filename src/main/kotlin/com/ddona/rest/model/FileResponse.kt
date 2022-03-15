package com.ddona.rest.model

data class FileResponse(
    var fileName: String,
    var downloadUrl: String,
    var fileType: String,
    var fileSize: Long = 0
)
