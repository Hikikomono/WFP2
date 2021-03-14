package com.example.glance.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.glance.R
import com.example.glance.TodoApplication
import com.example.glance.data.todo.Todo
import com.example.glance.data.todo.TodoViewModel
import com.example.glance.data.todo.TodoViewModelFactory
import com.example.glance.databinding.EditScreenBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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
        val args: EditTodoFragmentArgs by navArgs()

        //TODO DELETE Toast ONLY FOR TESTING
        Toast.makeText( context, "itemID: ${args.itemId}", Toast.LENGTH_SHORT).show()


        //TODO evtl. separat implementieren
        binding.areaIcon.setOnClickListener { view: View ->
            if (!binding.textInputTitleInputField.text.isNullOrBlank()){
                val todoTitle = binding.textInputTitleInputField.text.toString()
                val todoDescription = binding.textInputDescriptionInputField.text.toString() ?: ""
                val todo = Todo(0, "Inbox", todoTitle, todoDescription, false )
                todoViewModel.insert(todo)
                findNavController().navigateUp()
            }
        }
    }
}