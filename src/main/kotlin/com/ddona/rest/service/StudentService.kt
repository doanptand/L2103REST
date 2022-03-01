package com.ddona.rest.service

import com.ddona.rest.model.Student
import com.ddona.rest.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class StudentService {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    fun getAllStudents(): List<Student> {
        return studentRepository.findAll().toList()
    }

    fun getStudentById(id: Int): Student? {
        return studentRepository.findByIdOrNull(id)
    }

    fun addStudent(student: Student): Student? {
        if (studentRepository.findByIdOrNull(student.id) == null) {
            return studentRepository.save(student)
        }
        return null
    }

    fun updateStudent(student: Student): Student? {
        if (studentRepository.findByIdOrNull(student.id) != null) {
            return studentRepository.save(student)
        }
        return null
    }

    fun deleteStudent(id: Int) {
        return studentRepository.deleteById(id)
    }

}