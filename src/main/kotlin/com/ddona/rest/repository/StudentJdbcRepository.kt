package com.ddona.rest.repository

import com.ddona.rest.model.StudentJDBC
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class StudentJdbcRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    private val studentMapper = RowMapper<StudentJDBC> { rs, _ ->
        StudentJDBC(
            rs.getInt("col_id"),
            rs.getString("col_name"),
            rs.getString("col_address"),
            rs.getString("col_class"),
            rs.getFloat("col_point")
        )
    }

    fun getAllStudent(): List<StudentJDBC> {
        return jdbcTemplate.query("SELECT * FROM tb_student", studentMapper)
    }


    fun getStudentById(id: Int): StudentJDBC? {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM tb_student WHERE col_id=?",
            arrayOf(id),
            studentMapper
        )
    }

    fun addStudent(student: StudentJDBC) {
        jdbcTemplate.execute(
            "INSERT INTO tb_student(col_name, col_address, col_class, col_point) VALUES('${student.name}','${student.address}','${student.className}',${student.score})",
        )
    }

    fun updateStudent(student: StudentJDBC): Int {
        return jdbcTemplate.update(
            "UPDATE tb_student SET col_name=?, col_address=?, col_class=?, col_point=? WHERE col_id=?",
            student.name, student.address, student.className, student.score, student.id
        )
    }

    fun deleteStudent(id: Int): Int {
        return jdbcTemplate.update("DELETE FROM tb_student WHERE col_id=?", id)
    }
}