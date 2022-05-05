package com.opsu.thesaurus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opsu.thesaurus.MainActivity
import com.opsu.thesaurus.R

class SetsAdapter(private val inflater: LayoutInflater, val sets: List<MainActivity.Set>) : RecyclerView.Adapter<SetsAdapter.ViewHolder>()
{

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
        {
            val setName = view.findViewById<TextView>(R.id.txtSetName)
            val termsCount = view.findViewById<TextView>(R.id.txtTermsCount)
            val author = view.findViewById<TextView>(R.id.txtSetAuthor)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val set = sets[position]

        holder.setName.text = set.name
        holder.termsCount.text = set.numOfTerms.toString()
        holder.author.text = set.createdBy;
    }

    override fun getItemCount(): Int = sets.size


}