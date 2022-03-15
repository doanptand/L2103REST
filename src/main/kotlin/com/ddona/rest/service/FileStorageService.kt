package com.ddona.rest.service

import com.ddona.rest.config.FileProperties
import com.ddona.rest.exception.FileNotFoundException
import com.ddona.rest.exception.StorageException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Service
class FileStorageService @Autowired constructor(fileProperties: FileProperties) {
    private val fileStorageLocation: Path

    init {
        fileStorageLocation = Paths.get(fileProperties.uploadDir)
        try {
            Files.createDirectories(fileStorageLocation)
        } catch (e: IOException) {
            throw StorageException("Could not create the upload directory from server")
        }
    }

    fun saveFile(file: MultipartFile): String {
        val fileName = StringUtils.cleanPath(file.originalFilename!!)
        return try {
            if (fileName.contains("..")) {
                throw StorageException("Sorry! file name contain invalid charecter!: $fileName")
            }
            val targetLocation = fileStorageLocation.resolve(fileName)
            Files.copy(file.inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING)
            fileName
        } catch (e: IOException) {
            throw StorageException("Could not save file: $fileName")
        }
    }

    fun loadFileAsResource(fileName: String): Resource {
        return try {
            val filePath = fileStorageLocation.resolve(fileName).normalize()
            val resource = UrlResource(filePath.toUri())
            if (resource.exists()) {
                resource
            } else {
                throw FileNotFoundException("Find not found exception for $fileName")
            }
        } catch (e: MalformedURLException) {
            throw StorageException("Something went wrong!")
        }
    }

}