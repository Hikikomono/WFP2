package com.example.glance.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.glance.R
import com.example.glance.databinding.*


class OverviewFragment : Fragment() {
    private lateinit var binding: OverviewScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.overview_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        
        //Navigate to EditTodoFragment
        binding.floatingActionButton.setOnClickListener { view: View ->
            this.findNavController().navigate(R.id.action_OverviewFragment_to_EditScreenFragment)
        }

        //Navigate to TodoListFragment
        binding.inboxLayout.setOnClickListener { view1 : View ->
            this.findNavController().navigate(R.id.action_OverviewFragment_to_TodoListFragment)
        }

    }
}
