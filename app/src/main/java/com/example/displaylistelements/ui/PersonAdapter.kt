package com.example.displaylistelements.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.displaylistelements.databinding.PersonItemLayoutBinding
import com.example.displaylistelements.model.DTOPerson

class PersonAdapter(private val dataSet: List<DTOPerson>,
    private val openDetails: (DTOPerson) -> Unit): RecyclerView.Adapter<PersonViewHolder>(){

    /**
     * Create the ViewHolder defined in the RecyclerView.Adapter<T>
     * This one will be called ONCE
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            PersonItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            openDetails
        )
    }

    /**
     * @return Int the size of the DataSet.
     */
    override fun getItemCount(): Int {
        return dataSet.size
    }

    /**
     * Connect / Bind the Data with the ViewHolder
     * it will be called getItemCount times
     */
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.onBind(dataSet[position])
    }

}