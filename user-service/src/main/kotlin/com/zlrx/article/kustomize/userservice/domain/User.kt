package com.zlrx.article.kustomize.userservice.domain

import javax.persistence.*


@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue
    var id: Long? = null,

    @Basic
    var name: String? = null
)