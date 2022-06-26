package com.zlrx.article.kustomize.userservice.service

import com.zlrx.article.kustomize.userservice.domain.User
import com.zlrx.article.kustomize.userservice.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    fun getUser(): List<User> = repository.findAll()

    fun saveUser(user: User): User = repository.save(user)

}