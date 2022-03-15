package com.ddona.rest.controller

import com.ddona.rest.model.News
import com.ddona.rest.service.NewsService
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
@RequestMapping("news")
class NewsController {

    @Autowired
    private lateinit var newsService: NewsService

    @GetMapping("/all")
    fun getAllNews(): List<News> {
        return newsService.getAllNews()
    }

    @GetMapping("/id/{id}")
    fun getNewsById(@PathVariable("id") id: Int): News {
        return newsService.getNewsById(id)
    }

    @GetMapping("/title/{title}")
    fun getNewsByTitle(@PathVariable("title") title: String): List<News> {
        return newsService.getNewsByTitle(title)
    }

    @PostMapping("/add")
    fun addNews(@RequestBody news: News): News? {
        return newsService.addNews(news)
    }

    @PutMapping("/update")
    fun updateNews(@RequestBody news: News): News? {
        return newsService.updateNews(news)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteNewsById(@PathVariable("id") id: Int) {
        newsService.deleteNewsById(id)
    }
}