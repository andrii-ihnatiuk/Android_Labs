package com.opsu.lab6

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(
    private val inflater: LayoutInflater, private val list: List<String>, private val colors: List<String>
    ) : RecyclerView.Adapter<ListAdapter.ViewHolder>()
{
    private lateinit var clickListener: ListItemClickListener

    interface ListItemClickListener
    {
        fun onItemClick(itemId: Int)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val number: TextView = view.findViewById(R.id.txtItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(
            R.layout.list_item,
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.number.text = list[position]

        val bg = holder.itemView.background
        if (bg is GradientDrawable)
            bg.setColor(Color.parseColor(colors.random()))

        holder.itemView.setOnClickListener {
            if (this::clickListener.isInitialized)
                clickListener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = list.size

    fun setOnItemClickListener(listener: ListItemClickListener)
    {
        clickListener = listener
    }

}