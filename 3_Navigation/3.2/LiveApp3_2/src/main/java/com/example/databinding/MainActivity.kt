package com.example.databinding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
private const val KEY_COUNTER = "myCounter"

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Lifecycle onCreate")

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER, 0)
        }

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.counting = counter.toString()

        binding.button.setOnClickListener {
            counter++
            binding.textView.text = counter.toString()
        }
        
        binding.intentButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Ich habe schon $counter mal geklickt")
            intent.type = "text/plain"
            val shareIntent = Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "Lifecycle onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "Lifecycle onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Lifecycle onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "Lifecycle onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Lifecycle onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "Lifecycle onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"Lifecycle onSaveInstanceState called")

        outState.putInt(KEY_COUNTER, counter)
    }

}
