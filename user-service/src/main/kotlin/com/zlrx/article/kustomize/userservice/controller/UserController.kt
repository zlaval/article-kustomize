package com.zlrx.article.kustomize.userservice.controller

import com.zlrx.article.kustomize.userservice.domain.User
import com.zlrx.article.kustomize.userservice.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("user")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getUser(): List<User> {
        return userService.getUser()
    }

    @PostMapping
    fun postUser(@RequestBody user: User): User {
        return userService.saveUser(user)
    }


}