package com.example.kotlinbasics

class Greeting(var text: String, var isPolite: Boolean) {

    fun makePolite() {
        isPolite = true
    }

    fun addToGreeting(string: String) {
        text = text + " $string"
    }

}
