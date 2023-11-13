package com.example.displaylistelements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.displaylistelements.databinding.ActivityMainBinding
import com.example.displaylistelements.model.DTOPerson
import com.example.displaylistelements.model.DataSourcePerson
import com.example.displaylistelements.ui.DetailPersonFragment
import com.example.displaylistelements.ui.PersonAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val openDetails: (DTOPerson)-> Unit = {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        //binding.listOfPersons.layoutManager = LinearLayoutManager(this)
        binding.listOfPersons.layoutManager = GridLayoutManager(this, 1)
        binding.listOfPersons.adapter =
            PersonAdapter(
                DataSourcePerson.generateListOfPerson()
            ) {
                navigateToPersonDetailsScreen(it)
            }

        Test(
            errorCallback = {

            },
            success = {

            }
        ) {

        }
    }

    private fun navigateToPersonDetailsScreen(personDetails: DTOPerson) {
        Toast.makeText(this, personDetails.toString(), Toast.LENGTH_SHORT).show()
        supportFragmentManager.beginTransaction()
            .add(R.id.detail_fragment_container, DetailPersonFragment.newInstance(personDetails))
            .addToBackStack(null)
            .commit()
    }
}

fun Test(errorCallback: (String)-> Unit, success: (DTOPerson) -> Unit, runnable: Runnable) {

}

/**
 * Need a data source that returns a list.
 * Create a item_layout xml file.
 * Create the RecyclerView ViewHolder
 * Create the RecyclerView Adapter
 * Find the recyclerview VIEW, and update Adapter and LayoutManager.
 */