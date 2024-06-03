package com.example.timetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.timetracker.databinding.FragmentQuestionsBinding


class QuestionsFragment : Fragment() {
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!
    private var distance: String? = null
    private var yearsRun: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val distanceSpinner: Spinner = rootView.findViewById(R.id.distanceSpinner)
        val distanceArrayAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.events_array, android.R.layout.simple_spinner_item)
        distanceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        distanceSpinner.adapter = distanceArrayAdapter
        distanceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, viewPosition: Int, rowId: Long) {
                val selectedDistanceString = parent.getItemAtPosition(viewPosition).toString()
                distance = selectedDistanceString

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        return rootView
    }


}

