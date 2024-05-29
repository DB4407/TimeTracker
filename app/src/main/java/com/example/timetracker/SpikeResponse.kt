package com.example.timetracker


import com.squareup.moshi.Json


class SpikeResponse {
    @Json(name = "hits")
    lateinit var spikeItems: List<SpikeItems>
}

class SpikeItems {
    @Json(name = "title")
    var title: String = ""
    @Json(name = "brand")
    var brand: String = ""
    @Json(name = "base_price")
    var price: Long = 0
    @Json(name = "image")
    var image: String = ""
}


