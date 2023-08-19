package com.example.myapplicationchristy.model

data class User(
    val login: String,
    val id: Long,
    val avatar_url: String
    // tambahkan properti lain yang sesuai dengan data dari API
)

data class SearchResponse(val items: List<User>)
data class UserDetail(
    val login: String,
    val name: String,
    val followers: Int,
    val following: Int,
    val avatar_url: String
)
