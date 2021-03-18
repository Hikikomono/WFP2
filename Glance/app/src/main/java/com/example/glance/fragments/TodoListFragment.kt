package com.example.glance.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.glance.R
import com.example.glance.TodoApplication
import com.example.glance.TodoListAdapter
import com.example.glance.data.todo.TodoViewModel
import com.example.glance.data.todo.TodoViewModelFactory
import com.example.glance.databinding.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs


class TodoListFragment : Fragment(), TodoListAdapter.OnItemClickListener {
    private lateinit var binding: TodoListViewBinding
    private lateinit var adapter: TodoListAdapter
    private val todoViewModel: TodoViewModel by activityViewModels {
        TodoViewModelFactory((context?.applicationContext as TodoApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.todo_list_view, container, false)

        //receive Area Name from Bundle
        val args: TodoListFragmentArgs? by navArgs()
        Toast.makeText(context, "from ${args?.areaName}", Toast.LENGTH_SHORT).show()

        //Init RecylcerView
        val recyclerView = binding.todosRecyclerView
        adapter = TodoListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        todoViewModel.allTodos.observe(viewLifecycleOwner, Observer {  todos ->
            todos.let { adapter.submitList(it) }
        } )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Navigate to EditScreen
        binding.floatingActionButton.setOnClickListener { view: View ->
            this.findNavController().navigate(R.id.action_TodoListFragment_to_EditScreenFragment)
        }
    }

    //imp. OnItemClickListener method
    override fun onItemClick(position: Int) {
        var itemDbKey = adapter.currentList.get(position).id
        this.findNavController()
            .navigate(TodoListFragmentDirections.actionTodoListFragmentToEditScreenFragment(itemDbKey))
    }
}