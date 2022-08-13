package com.example.springbootdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

class GreeterController(private val greeter: Greeter) {
    @GetMapping("/hello/byservice/{name}")
    fun helloByService(@PathVariable("name") name: String): HelloResponse{
        val message = greeter.sayHello(name)
        return HelloResponse(message)
    }
}