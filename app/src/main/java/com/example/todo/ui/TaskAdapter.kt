package com.example.todo.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entity.Task
import com.example.todo.R
import com.example.todo.generated.callback.OnClickListener
import kotlinx.android.synthetic.main.item_task.view.*
import kotlin.coroutines.coroutineContext

class TaskAdapter (private var items : ArrayList<Task>,  val context: Context, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = items.get(position)
        holder?.textViewItemDescription?.text = items[position].description
        holder?.textViewItemtTitle?.text = items[position].name
        holder.bind (task, itemClickListener)


    }

    override fun getItemCount(): Int = items.size

    fun updateInformation (items : ArrayList<Task>){
        this.items = items
        notifyDataSetChanged()
    }

    fun getItemSelected (position: Int): Task{
        return items.get(position)
    }







}

class ViewHolder ( itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewItemtTitle = itemView.textViewItemTitle
    val textViewItemDescription = itemView.textViewItemDescription

    fun bind(task: Task,clickListener: OnItemClickListener)
    {

        itemView.setOnClickListener {
            clickListener.onItemClicked(task)
        }
    }

}

interface OnItemClickListener{
    fun onItemClicked(task: Task)
}