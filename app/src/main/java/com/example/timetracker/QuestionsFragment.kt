package com.example.timetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import com.example.timetracker.databinding.FragmentQuestionsBinding
import androidx.fragment.app.viewModels


class QuestionsFragment : Fragment() {
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!
    private var distance: Int = 0
    private var experience: String = ""
    private val viewModel: SpikeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val beginner: RadioButton = rootView.findViewById(R.id.beginnerBut)
        beginner.setOnClickListener{
            viewModel._experience = "beginner"
        }
        val intermediate: RadioButton = rootView.findViewById(R.id.intermediateBut)
        intermediate.setOnClickListener{
            viewModel._experience = "intermediate"
        }
        val experienced: RadioButton = rootView.findViewById(R.id.experiencedBut)
        experienced.setOnClickListener{
            viewModel._experience = "experienced"
        }



        val distanceSpinner: Spinner = rootView.findViewById(R.id.distanceSpinner)
        val distanceArrayAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.events_array, android.R.layout.simple_spinner_item)
        distanceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        distanceSpinner.adapter = distanceArrayAdapter
        distanceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, viewPosition: Int, rowId: Long) {
                val selectedDistanceString = parent.getItemAtPosition(viewPosition).toString()
                distance = selectedDistanceString.toInt()



            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.next.setOnClickListener{
            val action = QuestionsFragmentDirections.actionQuestionsFragmentToSummary(distance, experience)

            rootView.findNavController().navigate(action)
        }
        return rootView
    }


}

