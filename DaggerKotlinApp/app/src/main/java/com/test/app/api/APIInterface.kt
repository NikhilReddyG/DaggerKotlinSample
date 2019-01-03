package com.test.app.api

import com.test.app.model.Album
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("albums")
    fun fetchAlbums(): Call<List<Album>>
}