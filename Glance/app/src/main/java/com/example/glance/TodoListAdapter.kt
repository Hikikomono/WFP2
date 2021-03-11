package com.example.glance

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter : ListAdapter<Todo, TodoListAdapter.TodoViewHolder>(TodoComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val current = getItem(position)
    }

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val todoItemView: CheckBox = itemView.findViewById(R.id.singleTaskView)

        fun bind(text: String?){
            todoItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup) : TodoViewHolder{
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.single_task, parent, false)
                return TodoViewHolder(view)
            }
        }
    }

    //TODO Comparator noch anpassen
    class TodoComparator : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.title == newItem.title
        }
    }
}

