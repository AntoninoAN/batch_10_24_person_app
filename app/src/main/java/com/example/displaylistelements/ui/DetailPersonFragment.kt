package com.example.displaylistelements.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.displaylistelements.databinding.FragmentPersonDetailLayoutBinding
import com.example.displaylistelements.databinding.PersonItemLayoutBinding
import com.example.displaylistelements.model.DTOPerson

class DetailPersonFragment : Fragment(){

    companion object {
        const val PERSON_DETAILS = "PERSON_DETAILS"
        fun newInstance(personDTO: DTOPerson) =
            DetailPersonFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PERSON_DETAILS, personDTO)
                }
            }
    }

    private lateinit var detailPersonItemLayoutBinding: FragmentPersonDetailLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailPersonItemLayoutBinding = FragmentPersonDetailLayoutBinding
            .inflate(inflater)

        arguments?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelable(PERSON_DETAILS, DTOPerson::class.java)?.let { dtoPerson ->
                    setupUI(dtoPerson)
                }
            } else {
                it.getParcelable<DTOPerson>(PERSON_DETAILS)?.let { dtoPerson->
                    setupUI(dtoPerson)
                }
            }
        }

        return detailPersonItemLayoutBinding.root
    }

    private fun setupUI(dtoPerson: DTOPerson) {
        detailPersonItemLayoutBinding.apply {
            tvDetailsFname.text = dtoPerson.firstName
            tvDetailsLname.text = dtoPerson.lastName
            tvDetailsStreet.text = dtoPerson.address.streetName
            tvDetailsCity.text = dtoPerson.address.city
            tvDetailsCounty.text = dtoPerson.address.county
            tvDetailsCountry.text = dtoPerson.address.country
        }
    }

}