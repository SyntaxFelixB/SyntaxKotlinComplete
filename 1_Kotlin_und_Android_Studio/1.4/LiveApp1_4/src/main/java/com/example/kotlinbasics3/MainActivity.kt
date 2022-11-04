package com.example.kotlinbasics3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.random_image)
        val imageTwo = findViewById<ImageView>(R.id.random_two_image)
        val generateButton = findViewById<Button>(R.id.generate_button)

        val hand = Hand()
        val handTwo = Hand()

        generateButton.setOnClickListener {
            hand.roll()
            handTwo.roll()
            image.setImageResource(hand.imageId)
            imageTwo.setImageResource(handTwo.imageId)
        }
    }
}
