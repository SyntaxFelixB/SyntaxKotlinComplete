package com.example.kotlinbasics3


//
//    val x: Int = 7
//
//    val kotlinTeacher = Teacher(
//        "André",
//        "Mittelstreet 3",
//        "andi@wien.at",
//        "04.04.1984",
//        12345665,
//        true
//    )
//
//
//    kotlinTeacher.worksGood = false
//
//    kotlinTeacher.adress = "Neuerweg 84"
//
//
//    val swiftTeacher = Teacher(
//        insuranceNr = 1234567543,
//        adress = "Halbstraße 1/2",
//        name = "Max",
//        email = "max@max.de",
//        birthDate = "23.11.1599",
//    )
//
//
//    val canary: Bird = Bird("Richard")
//
//    canary.live()
//    canary.eat()
//    canary.move()
//
//    canary.brain



open class Animal(
    val brain: Boolean = true
) {
    fun live() {
        //do stuff
    }

    open fun eat() {
        // eat something
    }

    open fun move() {
        // move yourself
    }
}


class Bird(val name: String) : Animal() {
    override fun eat() {
        // first feed children
        super.eat()
    }

    override fun move() {
        // fly
    }
}


class Teacher(
    val name: String,
    var adress: String,
    var email: String,
    val birthDate: String,
    val insuranceNr: Int,
    var worksGood: Boolean = true  //default Wert
)


