package com.example.todoapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.models.Priority
import com.example.todoapp.data.models.ToDoData
import com.example.todoapp.databinding.RowLayoutBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()

    class MyViewHolder(val binding:RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowLayoutBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleTxt.text = dataList[position].title
        holder.binding.descriptionTxt.text = dataList[position].description

        when(dataList[position].priority){
            Priority.HIGH -> {
                holder.binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.binding.priorityIndicator.context,R.color.red))
            }
            Priority.MEDIUM -> {
                holder.binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.binding.priorityIndicator.context,R.color.yellow))
            }
            Priority.LOW -> {
                holder.binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.binding.priorityIndicator.context,R.color.green))
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun setData(toDoData: List<ToDoData>){
        this.dataList= toDoData
        notifyDataSetChanged()
    }
}