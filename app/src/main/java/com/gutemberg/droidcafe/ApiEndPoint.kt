package com.gutemberg.droidcafe

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET(value = "droidcafe")
    fun getProdutos():Call<List<Produto>>
}