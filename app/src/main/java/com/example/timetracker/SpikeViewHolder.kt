package com.example.timetracker

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.timetracker.databinding.ListItemBinding

class SpikeViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentSpike: Spike
    fun bindSpike(spike: Spike) {
        currentSpike = spike
        binding.spikeName.text = spike.title
        binding.priceText.text = "$" + spike.price.toString()
        binding.brandName.text = spike.brand
        val imageUrl = currentSpike.image
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(itemView.context)
            .load(imageUri)
            .into(binding.spikeView)


    }


}
