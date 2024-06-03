package com.example.timetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.timetracker.databinding.FragmentMainBinding
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.timetracker.databinding.FragmentSummaryBinding

class summary : Fragment() {
    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SpikeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val args = summaryArgs.fromBundle(requireArguments())
        if(args.distance == 100 || args.distance ==200)
            binding.summary.text=getString(R.string.workout100to200m)

        binding.next.setOnClickListener{
            //           val action = QuestionsFragmentDirections.actionQuestionsFragmentToSummaryFragment(distance, experience)

            rootView.findNavController().navigate(R.id.action_summary_to_spikeList)
        }
        return rootView
    }


}