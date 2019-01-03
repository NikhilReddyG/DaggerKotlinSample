package com.test.mvvmsample.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.test.app.api.UserService
import com.test.app.model.Album
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumViewModel : ViewModel() {

    var mAlbumList: MutableLiveData<List<Album>> = MutableLiveData()

    fun albumListResponse(): MutableLiveData<List<Album>> {
        return fetchAlbums()
    }

    private fun fetchAlbums(): MutableLiveData<List<Album>> {
        UserService().create().fetchAlbums().enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                mAlbumList.value = response.body()!!
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
            }
        })
        return mAlbumList
    }
}