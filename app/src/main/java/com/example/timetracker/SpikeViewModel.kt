package com.example.timetracker

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpikeViewModel : ViewModel() {
    var _experience = ""
    val experience: String
        get() = _experience
    private var _distance = MutableLiveData(0)
    val distance: LiveData<Int>
        get() = _distance

    private val _response = MutableLiveData<List<Spike>>()
    val response: LiveData<List<Spike>>
        get() = _response

    fun getSpikes() {
        val request = SpikeApiObject.spikeApiObject.getSpikes()
        request.enqueue(object : Callback<SpikeResponse> {
            override fun onFailure(call: Call<SpikeResponse>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }

            override fun onResponse(call: Call<SpikeResponse>, response: Response<SpikeResponse>) {
                var listOfSpikesFetched = mutableListOf<Spike>()
                val spikeResponse: SpikeResponse? = response.body()
                val spikeItems = spikeResponse?.spikeItems ?: listOf()
                for (spikeItem in spikeItems) {
                    val title = spikeItem.title
                    val brand = spikeItem.brand
                    val price = spikeItem.price
                    val image = spikeItem.image

                    val newSpike = Spike(title, brand, price, image)
                    listOfSpikesFetched.add(newSpike)
                }
                _response.value = listOfSpikesFetched
            }
        })
    }


}