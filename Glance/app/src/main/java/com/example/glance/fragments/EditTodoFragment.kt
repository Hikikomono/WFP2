package com.example.glance.fragments

import android.os.Bundle
import android.text.Editable
import android.util.DebugUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.glance.R
import com.example.glance.TodoApplication
import com.example.glance.data.todo.Todo
import com.example.glance.data.todo.TodoViewModel
import com.example.glance.data.todo.TodoViewModelFactory
import com.example.glance.databinding.EditScreenBinding
import kotlinx.coroutines.launch
import java.util.*


class EditTodoFragment : Fragment() {
    private lateinit var binding: EditScreenBinding

    private val todoViewModel: TodoViewModel by activityViewModels {
        TodoViewModelFactory((context?.applicationContext as TodoApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.edit_screen, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init safeArgs variable


        //TODO DELETE Toast ONLY FOR TESTING
        val args: EditTodoFragmentArgs by navArgs()
        var itemId = args.itemId

        if (itemId != -1){
            todoViewModel.viewModelScope.launch {
                var tmpTodo = todoViewModel.getTodoFromDatabase(args.itemId)
                var title = tmpTodo.title
                var description = tmpTodo.description
                binding.textInputTitleInputField.setText(title)
                binding.textInputDescriptionInputField.setText(description)
            }

            Toast.makeText(
                context, "itemID: ${args.itemId}", Toast.LENGTH_SHORT
            ).show()
        }

        //TODO evtl. separat implementieren
        binding.areaIcon.setOnClickListener { view: View ->
            if (itemId === -1) {
                var todoTitle = binding.textInputTitleInputField.text.toString()
                var todoDescription = binding.textInputDescriptionInputField.text.toString() ?: ""
                var todo = Todo(
                    0, "Inbox", todoTitle, todoDescription,
                    Date(2020, 4, 20), Date(2020, 4, 20),
                    Date(2020, 4, 20), Date(2020, 4, 20),
                    false
                )
                todoViewModel.insert(todo)

            } else {
                todoViewModel.viewModelScope.launch {
                    var tmpTodo = todoViewModel.getTodoFromDatabase(args.itemId)
                    var title = binding.textInputTitleInputField.toString()
                    var description = binding.textInputDescriptionInputField.toString()
                    tmpTodo.title = title
                    tmpTodo.description = description
                    todoViewModel.updateTodo(tmpTodo)
                }
            }
            findNavController().navigateUp()
        }
    }
}