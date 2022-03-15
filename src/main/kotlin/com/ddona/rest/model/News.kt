package com.ddona.rest.model

import javax.persistence.*

@Entity
@Table(name = "news")
data class News(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="_id")
    var id: Int,
    @Column(name="_title")
    var title: String,
    @Column(name="_content")
    var content: String,
    @Column(name="_pub_date")
    var pubDate: Long,
)
