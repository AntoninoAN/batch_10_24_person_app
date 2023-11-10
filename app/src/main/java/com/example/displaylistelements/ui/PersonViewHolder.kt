package com.example.displaylistelements.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.displaylistelements.databinding.PersonItemLayoutBinding
import com.example.displaylistelements.model.DTOPerson

class PersonViewHolder(private val personItemLayoutBinding: PersonItemLayoutBinding,
    private val sendDataDTOPersonDetails: (DTOPerson) -> Unit):
    RecyclerView.ViewHolder(personItemLayoutBinding.root) {

        fun onBind(personItem: DTOPerson) {
            personItemLayoutBinding.tvFirstName.text = personItem.firstName
            personItemLayoutBinding.tvLastName.text = personItem.lastName
            personItemLayoutBinding.tvAge.text = personItem.age.toString()

            personItemLayoutBinding.root.setOnClickListener {
                sendDataDTOPersonDetails(personItem)
            }
        }
}