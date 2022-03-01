package com.ddona.rest.model

import javax.persistence.*

@Entity
@Table(name="tb_student")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="col_id")
    var id: Int,
    @Column(name="col_name")
    var name: String,
    @Column(name="col_address")
    var address: String,
    @Column(name="col_class")
    var className: String,
    @Column(name="col_point")
    var score: Float
)
