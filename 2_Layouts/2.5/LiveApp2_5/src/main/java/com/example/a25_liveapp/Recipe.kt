package com.example.a25_liveapp

class Recipe(
    val name: String,
    val ingredients: MutableList<String>
) {

    fun makeVegan() {
        ingredients.remove("Hirtenkäse")
    }

    fun makeSpicy() {
        ingredients.add("Chilli")
    }

}