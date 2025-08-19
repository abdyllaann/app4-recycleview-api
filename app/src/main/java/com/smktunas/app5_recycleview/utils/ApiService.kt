package com.smktunas.app5_recycleview.utils

import com.smktunas.app5_recycleview.model.Buku
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("buku")
    fun getBuku(): Call<List<Buku>>
}