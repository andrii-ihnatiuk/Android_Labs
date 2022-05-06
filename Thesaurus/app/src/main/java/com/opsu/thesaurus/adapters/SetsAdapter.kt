package com.opsu.thesaurus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opsu.thesaurus.R
import com.opsu.thesaurus.fragments.HomeFragment

class SetsAdapter(private val inflater: LayoutInflater, private val sets: List<HomeFragment.SetModel>) : RecyclerView.Adapter<SetsAdapter.ViewHolder>()
{
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
        {
            val setName: TextView = view.findViewById(R.id.txtSetName)
            val termsCount: TextView = view.findViewById(R.id.txtTermsCount)
            val author:TextView = view.findViewById(R.id.txtSetAuthor)
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