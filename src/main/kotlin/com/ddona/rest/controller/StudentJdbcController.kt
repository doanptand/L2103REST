package com.ddona.rest.controller

import com.ddona.rest.model.StudentJDBC
import com.ddona.rest.service.StudentJdbcService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/student")
class StudentJdbcController {
    @Autowired
    private lateinit var studentService: StudentJdbcService


    @GetMapping("/all")
    fun getAllStudent(): List<StudentJDBC> {
        return studentService.getAllStudent()
    }

    @GetMapping("/id/{id}")
    fun getStudentById(@PathVariable("id") id: Int): StudentJDBC? {
        return studentService.getStudentById(id)
    }

    @PostMapping("/add")
    fun addStudent(@RequestBody student: StudentJDBC) {
        return studentService.addStudent(student)
    }

    @PutMapping("/update")
    fun updateStudent(@RequestBody student: StudentJDBC): Int {
        return studentService.updateStudent(student)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteStudent(@PathVariable("id") id: Int): Int {
        return studentService.deleteStudent(id)
    }
}