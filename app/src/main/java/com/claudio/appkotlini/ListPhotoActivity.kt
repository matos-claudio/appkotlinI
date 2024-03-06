package com.claudio.appkotlini

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPhotoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_photo)

        recyclerView = findViewById(R.id.recyclerView)

        adapter = PhotoAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = adapter

//        val photoService = RetrofitClient.createPhotoService()
//        val albumsService = RetrofitClient.createService(IAlbumService::class.java)
//        val call1 = albumsService.getAlbums()

        val photoService = RetrofitClient.createService(IPhotoService::class.java)
        val call = photoService.getPhotos()
        call.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
               if (response.isSuccessful) {
                   val photos = response.body()
                   if(photos != null) {
                       adapter = PhotoAdapter(photos)
                       recyclerView.adapter = adapter
                       adapter.notifyDataSetChanged()
                   }
               } else {
                   println("Erro ao buscar as fotos ${response.code()}")
               }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                println("Erro ao buscar as fotos ${t.message}")
            }
        })
    }
}