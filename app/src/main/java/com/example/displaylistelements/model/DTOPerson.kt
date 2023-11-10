package com.example.displaylistelements.model

data class DTOPerson(
    val firstName: String,
    val lastName: String,
    val address: Address,
    val age: Int,
    val favoriteSport: String
)

data class Address(
    val number: String,
    val streetName: String,
    val city: String,
    val county: String,
    val country: String
)