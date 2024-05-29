package com.example.timetracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetracker.databinding.ListItemBinding

class SpikeAdapter(val spikeList: List<Spike>): RecyclerView.Adapter<SpikeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpikeViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpikeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return spikeList.size
    }

    override fun onBindViewHolder(holder: SpikeViewHolder, position: Int) {
        val currentSpike = spikeList[position]
        holder.bindSpike(currentSpike)

    }
}
