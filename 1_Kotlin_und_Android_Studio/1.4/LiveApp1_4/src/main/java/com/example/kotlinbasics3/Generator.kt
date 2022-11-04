package com.example.kotlinbasics3

abstract class Generator {

    abstract var possibilities: Int
    abstract var imageId: Int

    fun roll() {
        val number = (1..possibilities).random()
        setImage(number)
    }

    abstract fun setImage(number: Int)

}