package com.zlrx.article.kustomize.userservice.repository

import com.zlrx.article.kustomize.userservice.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>