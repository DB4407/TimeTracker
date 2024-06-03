package com.example.timetracker

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val QUERY_STRING =
    "search?query=maxfly&rapidapi-key=2d274a5fb6mshfaad5e53359cf34p12bdb5jsn6c7153d750ef"

interface SpikeApiInterface {
    @GET(QUERY_STRING)
    fun getSpikes(): Call<SpikeResponse>


}

private const val BASE_URL = "https://stockx-api.p.rapidapi.com/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofitObject = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
    MoshiConverterFactory.create(moshi)
).build()

object SpikeApiObject {
    val spikeApiObject: SpikeApiInterface by lazy {
        retrofitObject.create(SpikeApiInterface::class.java)
    }
}