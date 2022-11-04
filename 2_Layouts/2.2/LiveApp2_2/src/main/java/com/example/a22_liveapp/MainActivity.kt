package com.example.a22_liveapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.a22_liveapp.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var counter = 10

        Log.i(TAG, "Hallo diese App startet mir einen Counter und der hat anfangs den Wert $counter")

        Log.v(TAG, "Allgemeiner Log")

        Log.d(TAG, "Debug Log")

        Log.i(TAG, "Info Log")

        Log.w(TAG, "Warning Log")

        Log.e(TAG, "Error Log")

        Log.wtf(TAG, "unvorstellbar problematischer Log")

        for (i in (0..3)) {
            Log.d(TAG, "For loop value i = $i")
            try {
                val y = 10 / i
            } catch (e: Exception) {
                Log.e(TAG, "For Loop Exception: $e")
            }
        }

        binding.clickButton.setOnClickListener {
            counter --

            Log.d(TAG, "Counter is $counter")

            try {
//                binding.counterText.text = (100 / counter).toString()
//                binding.counterBackText.text = binding.counterText.text
                binding.layoutCounter = counter
            } catch (e: Exception) {
                Log.e(TAG, "Counter failed: $e")
            }
        }
    }
}
