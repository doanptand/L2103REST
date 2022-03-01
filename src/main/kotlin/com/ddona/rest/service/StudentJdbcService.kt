package com.ddona.rest.service

import com.ddona.rest.model.StudentJDBC
import com.ddona.rest.repository.StudentJdbcRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentJdbcService {

    @Autowired
    private lateinit var studentRepository: StudentJdbcRepository

    fun getAllStudent(): List<StudentJDBC> {
        return studentRepository.getAllStudent()
    }

    fun getStudentById(id: Int): StudentJDBC? {
        return studentRepository.getStudentById(id)
    }

    fun addStudent(student: StudentJDBC) {
        return studentRepository.addStudent(student)
    }

    fun updateStudent(student: StudentJDBC): Int {
        return studentRepository.updateStudent(student)
    }

    fun deleteStudent(id: Int): Int {
        return studentRepository.deleteStudent(id)
    }
}