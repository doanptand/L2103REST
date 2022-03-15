package com.ddona.rest.controller

import com.ddona.rest.model.FileResponse
import com.ddona.rest.service.FileStorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.io.File

@RestController
@RequestMapping("/files")
class FileController {

    @Autowired
    private lateinit var storageService: FileStorageService

    //http://localhost:8888/files/upload
    @PostMapping("/upload")
    fun uploadFile(@RequestParam("file") file: MultipartFile): FileResponse {
        val fileName = storageService.saveFile(file)
        //http://localhost:8888/files/download/android.apk
        val downloadUrl = ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path("/files/download/")
            .path(fileName).toUriString()
        return FileResponse(
            fileName,
            downloadUrl,
            file.contentType!!,
            file.size
        )
    }

    @PostMapping("/uploads")
    fun uploadFiles(@RequestParam("files") files: Array<MultipartFile>): List<FileResponse> {
        val responses = arrayListOf<FileResponse>()
        for(file in files) {
            val response = uploadFile(file)
            responses.add(response)
        }
        return responses
    }
}