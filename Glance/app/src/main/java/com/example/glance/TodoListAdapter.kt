package com.example.glance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.glance.data.todo.Todo

class TodoListAdapter(private val listener: OnItemClickListener) : ListAdapter<Todo, TodoListAdapter.TodoViewHolder>(TodoComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_task, parent, false)
        return TodoViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.title, current.area)
    }

     inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
         private val todoItemTitle: CheckBox = itemView.findViewById(R.id.singleTaskView)
         private val todoItemArea: TextView = itemView.findViewById(R.id.singleTaskView_area_title)

         //Code for OnClickListener
         init {
             itemView.setOnClickListener(this)
         }

         override fun onClick(v: View?) {
             //define what happens if itemView is clicked
             val position = adapterPosition
             //check if Position is still valid (in case of Animation e.g.)
             if (position != RecyclerView.NO_POSITION)
                listener.onItemClick(position)
         }

         fun bind(textTitle: String?, textArea: String?) {
             todoItemTitle.text = textTitle
             todoItemArea.text = textArea
         }
     }
    //could be solved via Lambda
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
/*
        companion object {
            fun create(parent: ViewGroup) : TodoViewHolder {

            }
        }
    }

 */




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

