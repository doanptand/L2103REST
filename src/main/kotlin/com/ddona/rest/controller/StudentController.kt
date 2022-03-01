package com.ddona.rest.controller

import com.ddona.rest.model.Student
import com.ddona.rest.service.StudentService
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
@RequestMapping("/student_jpa")
class StudentController {

    @Autowired
    private lateinit var studentService: StudentService

    @GetMapping("/all")
    fun getAllStudents(): List<Student> {
        return studentService.getAllStudents()
    }

    @GetMapping("/id/{id}")
    fun getStudentById(@PathVariable("id") id: Int): Student? {
        return studentService.getStudentById(id)
    }

    @GetMapping("/name/{name}")
    fun getStudentByName(@PathVariable name: String): Student {
        return studentService.getStudentByName(name)
    }

    @GetMapping("/score/{score}")
    fun getStudentsByScore(@PathVariable score: Float): List<Student> {
        return studentService.getStudentHaveScoreGreaterThan(score)
    }

    @PostMapping("/add")
    fun addStudent(@RequestBody student: Student): Student? {
        return studentService.addStudent(student)
    }

    @PutMapping("/update")
    fun updateStudent(@RequestBody student: Student): Student? {
        return studentService.updateStudent(student)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteStudent(@PathVariable id: Int) {
        return studentService.deleteStudent(id)
    }
}