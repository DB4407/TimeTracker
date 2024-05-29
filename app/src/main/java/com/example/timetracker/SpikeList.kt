package com.example.timetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.timetracker.databinding.FragmentMainBinding
import com.example.timetracker.databinding.FragmentSpikeListBinding


class SpikeList : Fragment() {
    private var _binding: FragmentSpikeListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SpikeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpikeListBinding.inflate(inflater, container, false)
        viewModel.getSpikes()
        val rootView = binding.root
        viewModel.response.observe(viewLifecycleOwner, { spikeList ->
            val mAdapter = SpikeAdapter(spikeList)
            binding.recyclerView.adapter = mAdapter
        })


        // Inflate the layout for this fragment
        return rootView
    }


}

