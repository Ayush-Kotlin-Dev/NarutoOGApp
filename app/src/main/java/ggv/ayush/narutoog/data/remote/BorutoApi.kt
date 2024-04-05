package ggv.ayush.narutoog.data.remote

import ggv.ayush.narutoog.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {
    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Any = 1
    ):ApiResponse


    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name")name : String
    ):ApiResponse


}