package com.example.timetracker

import android.os.Bundle
import android.view.*
import androidx.compose.runtime.State
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.manager.Lifecycle
import com.example.timetracker.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val menuHost: MenuHost = requireActivity()
        binding.startBut.setOnClickListener{
            rootView.findNavController().navigate(R.id.action_mainFragment_to_questionsFragment)
        }


        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return NavigationUI.onNavDestinationSelected(
                    menuItem,
                    requireView().findNavController()
                )
            }

        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)
        return rootView

    }


}

