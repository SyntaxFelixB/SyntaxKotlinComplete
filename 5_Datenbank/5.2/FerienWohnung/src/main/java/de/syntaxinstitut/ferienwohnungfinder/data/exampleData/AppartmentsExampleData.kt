package de.syntaxinstitut.ferienwohnungfinder.data.exampleData

import de.syntaxinstitut.ferienwohnungfinder.R
import de.syntaxinstitut.ferienwohnungfinder.data.dataclasses.AppartmentData

object AppartmentsExampleData {

    val appartment1 = AppartmentData(
        title = "Ferienwohnung mit Meerblick",
        address = "Zandvoort, Niederlande",
        sleepRooms = 2,
        size = 50,
        persons = 4,
        petsAllowed = false,
        pricePerNight = 79,
        image = R.drawable.appartment1
    )

    val appartment2 = AppartmentData(
        title = "Wohnung mitten in der City",
        address = "Kopenhagen, Dänemark",
        sleepRooms = 1,
        size = 33,
        persons = 2,
        petsAllowed = false,
        pricePerNight = 65,
        image = R.drawable.appartment2
    )

    val appartment3 = AppartmentData(
        title = "Tierfreundliches Haus am Steinhuder Meer",
        address = "Steinhude, Deutschland",
        sleepRooms = 3,
        size = 85,
        persons = 5,
        petsAllowed = true,
        pricePerNight = 129,
        image = R.drawable.appartment3
    )

    val appartment4 = AppartmentData(
        title = "Eifelturmblick",
        address = "Paris, Frankreich",
        sleepRooms = 2,
        size = 55,
        persons = 3,
        petsAllowed = false,
        pricePerNight = 99,
        image = R.drawable.appartment4
    )

    val appartment5 = AppartmentData(
        title = "Hauptstadtfeeling erleben",
        address = "Berlin, Deutschland",
        sleepRooms = 1,
        size = 30,
        persons = 1,
        petsAllowed = false,
        pricePerNight = 75,
        image = R.drawable.appartment5
    )

    val appartment6 = AppartmentData(
        title = "Aufwachen mit Bergpanorama",
        address = "Bischofshofen, Österreich",
        sleepRooms = 4,
        size = 120,
        persons = 7,
        petsAllowed = true,
        pricePerNight = 149,
        image = R.drawable.appartment6
    )
}