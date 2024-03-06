package com.claudio.appkotlini

import retrofit2.Call
import retrofit2.http.GET

interface IAlbumService {
    @GET("/albums")
    fun getAlbums(): Call<List<Album>>
}