package com.example.myapplicationchristy.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApiService {
    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): Response<SearchResponse>

    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): Response<UserDetail>
}
