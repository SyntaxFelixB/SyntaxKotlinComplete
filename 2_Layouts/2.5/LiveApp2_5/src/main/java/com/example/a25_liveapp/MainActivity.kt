package com.example.a25_liveapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.a25_liveapp.databinding.ActivityMainBinding

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val pasta = Recipe(
            "MyCheapPasta",
            mutableListOf(
                "Penne",
                "Tomaten Sauce",
                "Salz",
                "Basilikum"
            )
        )

        binding.veganButton.setOnClickListener {

            val salat = makeNewSalat()

            salat.makeVegan()
            binding.titleText.text = salat.name
            binding.subtitleText.text = salat.ingredients.toString()
        }

        binding.normalButton.setOnClickListener {

            val salat = makeNewSalat()

            binding.titleText.text = salat.name
            binding.subtitleText.text = salat.ingredients.toString()
        }

        binding.hotButton.setOnClickListener {
            val salat = makeNewSalat()

            salat.makeSpicy()

            binding.titleText.text = salat.name
            binding.subtitleText.text = salat.ingredients.toString()
        }
    }

    fun makeNewSalat(): Recipe {
        val newSalat = Recipe(
            "klassicher Bauernsalat",
            mutableListOf(
                "Vogerlsalat",
                "Tomaten",
                "Gurken",
                "Hirtenkäse",
                "Oliven",
                "Dressing"
            )
        )
        return newSalat
    }

//    fun myTest() {
//        Log.d(TAG, "myTest function started")
//
//        try {
//            val fail = 20 / 0
//        } catch (e: Exception) {
//            Log.e(TAG, "myTest failed: $e")
//            val fail = 20/1
//        }
//
//    }
}
