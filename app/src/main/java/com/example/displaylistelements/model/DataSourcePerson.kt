package com.example.displaylistelements.model

object DataSourcePerson {

    fun generateListOfPerson(): List<DTOPerson> {
        return listOf(
            DTOPerson(
                "Antonino",
                "Ardines",
                Address(
                    "1234",
                    "Somewhere",
                    "SomePlace",
                    "Some some",
                    "US"
                ),
                37,
                "Soccer/Futbol!"
            ),DTOPerson(
                "adfadsfa",
                "Ardiasdfasdfsdanes",
                Address(
                    "1234",
                    "Somewhere",
                    "SomePlace",
                    "Some some",
                    "US"
                ),
                45455,
                "adfdasfadsfsdfa"
            ),DTOPerson(
                "Fernando",
                "Tejeda",
                Address(
                    "1234",
                    "Somewhere",
                    "SomePlace",
                    "Some some",
                    "US"
                ),
                28,
                "Video Games"
            ),DTOPerson(
                "Ally",
                "Hernandez",
                Address(
                    "1234",
                    "Somewhere",
                    "SomePlace",
                    "Some some",
                    "US"
                ),
                25,
                "Mommy take care of baby!"
            ),DTOPerson(
                "Roshan",
                "Saundankar",
                Address(
                    "1234",
                    "Somewhere",
                    "SomePlace",
                    "Some some",
                    "US"
                ),
                25,
                "Hiking"
            )
        )
    }
}