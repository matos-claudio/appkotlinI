package com.claudio.appkotlini

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private lateinit var INSTANCE: Retrofit
        private val BASE_URL = "https://jsonplaceholder.typicode.com"

        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if(!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return INSTANCE
        }

//        fun createPhotoService(): IPhotoService {
//            return getRetrofitInstance().create(IPhotoService::class.java)
//        }

        fun <T> createService(service: Class<T>): T {
            return getRetrofitInstance().create(service)
        }

    }
}
