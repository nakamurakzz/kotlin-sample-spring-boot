package com.example.springbootdemo

import com.example.springbootdemo.database.User
import com.example.springbootdemo.database.UserMapper
import com.example.springbootdemo.database.insert
import com.example.springbootdemo.database.selectByPrimaryKey
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class UserPostRequest(
    val id: Int,
    val name: String,
    val age: Int,
    val profile: String
)
data class UserPostResponse(
    val count: Int
)

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("user")
class UseController(val userMapper : UserMapper) {
    @GetMapping("/select/{id}")
    fun select(@PathVariable("id") id: Int): User? {
        return  userMapper.selectByPrimaryKey(id)
    }

    @PostMapping("/insert")
    fun insert(@RequestBody request: UserPostRequest): UserPostResponse {
        val record = User(request.id, request.name, request.age, request.profile)
        return UserPostResponse( userMapper.insert(record))
    }
}