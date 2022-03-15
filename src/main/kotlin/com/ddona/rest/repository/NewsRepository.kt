package com.ddona.rest.repository

import com.ddona.rest.model.News
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsRepository : CrudRepository<News, Int> {
    fun findNewsByTitleContains(title: String): List<News>
}