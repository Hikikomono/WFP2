package com.example.glance.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.glance.R
import com.example.glance.TodoApplication
import com.example.glance.data.todo.TodoViewModel
import com.example.glance.data.todo.TodoViewModelFactory

class EditTodoFragment : Fragment() {

    private val todoViewModel: TodoViewModel by activityViewModels {
        TodoViewModelFactory((context?.applicationContext as TodoApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}