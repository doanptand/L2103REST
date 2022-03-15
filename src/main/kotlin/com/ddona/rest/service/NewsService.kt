package com.ddona.rest.service

import com.ddona.rest.model.News
import com.ddona.rest.repository.NewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NewsService {

    @Autowired
    private lateinit var newsRepository: NewsRepository

    fun getAllNews(): List<News> {
        return newsRepository.findAll().toList()
    }

    fun getNewsById(id: Int): News {
        return newsRepository.findById(id).get()
    }

    fun getNewsByTitle(title: String): List<News> {
        return newsRepository.findNewsByTitleContains(title)
    }

    fun addNews(news: News): News? {
        if (!newsRepository.existsById(news.id)) {
            return newsRepository.save(news)
        }
        return null
    }

    fun updateNews(news: News): News? {
        if (newsRepository.existsById(news.id)) {
            return newsRepository.save(news)
        }
        return null
    }

    fun deleteNewsById(id: Int) {
        newsRepository.deleteById(id)
    }
}