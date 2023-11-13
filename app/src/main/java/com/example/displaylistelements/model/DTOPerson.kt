package com.example.displaylistelements.model

import android.os.Build
import android.os.Parcel
import android.os.Parcelable

data class DTOPerson(
    val firstName: String,
    val lastName: String,
    val address: Address,
    val age: Int,
    val favoriteSport: String
): Parcelable {
    // var name: String? = null
    // println(name?.length) Name: Safe call operator. Behavior: Checks if is null or not, before doing something. Returns null
    // name != null ? name.length : "na" Thernearies
    // (name?.length ?: throw NullPointerException()) Name: Elvis operator. Behavior: Evaluates left hand, if null executes right hand. Else returns left hand.
    // if (name!!.length == null) Name: Assertion operator. Behavior: Assert something is NEVER null, else triggers NPE.
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        //parcel.readParcelable<Address>(Address::class.java.classLoader) ?: throw Exception(),
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcel.readParcelable(Address::class.java.classLoader, Address::class.java) ?: throw Exception()
        } else {
            parcel.readParcelable<Address>(Address::class.java.classLoader) ?: throw Exception()
        },
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeString(favoriteSport)
        parcel.writeParcelable(address, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DTOPerson> {
        override fun createFromParcel(parcel: Parcel): DTOPerson {
            return DTOPerson(parcel)
        }

        override fun newArray(size: Int): Array<DTOPerson?> {
            return arrayOfNulls(size)
        }
    }
}

data class Address (
    val number: String,
    val streetName: String,
    val city: String,
    val county: String,
    val country: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(number)
        parcel.writeString(streetName)
        parcel.writeString(city)
        parcel.writeString(county)
        parcel.writeString(country)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }
}