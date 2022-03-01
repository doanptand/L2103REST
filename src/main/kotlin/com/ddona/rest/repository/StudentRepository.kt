package com.ddona.rest.repository

import com.ddona.rest.model.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Int> {
    //    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
    fun findByName(name: String): Student

    fun findByScoreIsGreaterThan(score: Float): List<Student>
}