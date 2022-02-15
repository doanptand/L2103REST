package com.ddona.rest.controller

import com.ddona.rest.model.User
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("hello")
class HelloController {

    //CRUD- CREATE - REQUEST - UPDATE- DELETE
    @GetMapping("/")
    fun sayHello(): String {
        return "Hello World"
    }

    @RequestMapping("/hi", method = [RequestMethod.GET, RequestMethod.POST])
    fun sayHi(): String {
        return "Hello Hi"
    }
    //localhost:8888/hello/hi/doan
    @GetMapping("/hi/{name}")
    fun sayHi(@PathVariable(name = "name") name: String): String {
        return "Hello $name"
    }
    //localhost:8888/hello/login
    @PostMapping("/login")
    fun login(@RequestBody user: User): String {
        //doanpt-deptrai -> Login success else -> Wrong username or password!
        return if(user.user == "doanpt" && user.pass == "deptrai") {
            "Login success"
        } else{
            "Wrong username or password!"
        }
    }




    //GET - POST- PUT/PATCH - DELETE

    //@RestController
    //@GetMapping
    //@PostMapping
    //@PutMapping
    //@PatchMapping
    //@DeleteMapping
    //@PathVariable
    //@RequestBody
    //@RequestMapping
    //Login: user-password
}