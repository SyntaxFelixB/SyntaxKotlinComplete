package com.example.kotlinbasics3

class Hand : Generator() {

    override var possibilities: Int = 3
    override var imageId: Int = 0

    // geerbt von Mama Generator
//    fun roll() {
//        val number = (1..possibilities).random()
//        setImage(number)
//    }

    override fun setImage(number: Int) {
        when (number) {
            1 -> imageId = R.drawable.paper
            2 -> imageId = R.drawable.scissor
            3 -> imageId = R.drawable.stone
            else -> imageId = R.drawable.ic_launcher_foreground
        }
    }
}
