package com.example.glance.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.glance.R
import com.example.glance.TodoApplication
import com.example.glance.data.todo.TodoViewModel
import com.example.glance.data.todo.TodoViewModelFactory
import com.example.glance.databinding.*
import kotlinx.coroutines.launch


class OverviewFragment : Fragment() {
    private lateinit var binding: OverviewScreenBinding

    private val todoViewModel: TodoViewModel by activityViewModels {
        TodoViewModelFactory((context?.applicationContext as TodoApplication).repository)
    }

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

        todoViewModel.viewModelScope.launch {
            binding.inboxCount.setText(todoViewModel.getTodoAreaCount("Inbox").toString())
        }

        
        //Navigate to EditTodoFragment
        binding.floatingActionButton.setOnClickListener { view: View ->
            this.findNavController().navigate(R.id.action_OverviewFragment_to_EditScreenFragment)
        }

        //Navigate to TodoListFragment
        binding.todayLayout.setOnClickListener{ view: View->
            this.findNavController().navigate(R.id.action_OverviewFragment_to_TodoListFragment)
        }

        binding.inboxLayout.setOnClickListener { view : View ->
            this.findNavController().navigate(R.id.action_OverviewFragment_to_TodoListFragment)
        }

    }
}
