package com.example.springbootdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class HelloResponse(val message: String)
data class HelloRequest(val name: String)

@RestController  // RestController アノテーションでレスポンスをJSONにシリアライズする
@RequestMapping("greeter")
class GreetingController(private val greeter: Greeter) {
    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {  // RequestParam でクエリパラメータを取得
        return HelloResponse("Hello $name")
    }

    @PostMapping("/hello")
    fun helloPostName(@RequestBody request: HelloRequest): HelloResponse{
        println(request)
        return HelloResponse("Hello ${request.name}")
    }

    @GetMapping("/hello/{name}")
    fun helloPathName(@PathVariable("name") name: String): HelloResponse {  // PathVariableパスパラメータ
        return HelloResponse("Hello $name")
    }

    @GetMapping("/hello/byservice/{name}")
    fun helloByService(@PathVariable("name") name: String): HelloResponse{
        val message = greeter.sayHello(name)
        return HelloResponse(message)
    }

}