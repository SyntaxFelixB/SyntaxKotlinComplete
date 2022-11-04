package com.example.a25b_liveapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.a25b_liveapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val roundCard = findViewById<MaterialCardView>(R.id.empty_card)

//        roundCard.setOnClickListener{
//            val songText = findViewById<TextView>(R.id.songtext_text)
//
//            songText.text = "Tralalaalala"
//        }

        binding.emptyCard.setOnClickListener {
            binding.songtextText.text = "DATA BINDING yeah"
            binding.textView2.text = "ich habe keine gute id"
        }

        binding.testButton.setOnClickListener {
            it.setBackgroundColor(resources.getColor(R.color.teal_700))
        }
    }
}
