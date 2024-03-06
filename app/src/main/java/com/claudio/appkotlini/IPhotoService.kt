package com.claudio.appkotlini

import retrofit2.Call
import retrofit2.http.GET

interface IPhotoService {
    @GET("/photos")
    fun getPhotos(): Call<List<Photo>>
}