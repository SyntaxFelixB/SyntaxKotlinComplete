package com.example.coroutines

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.loading.observe(
            this,
            Observer {
                if (it == true) {
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.GONE
                }
            }
        )

        binding.homeFab.setOnClickListener {
            viewModel.loadNewImage()
        }

        viewModel.image.observe(
            this,
            Observer {
                binding.imageText.text = it
            }
        )

//        var count = 0
//        for (i in 1..50) {
//            Thread {
//                count += 1
//                println("Thread: $i count: $count")
//            }.start()
//        }

//        var coroutineCount = 0
//        for (i in 1..50) {
//            lifecycleScope.launch {
//                coroutineCount +=1
//                println("Coroutine: $i count: $coroutineCount")
//            }
//        }

//        val myJob = lifecycleScope.launch {
//            println("Job started")
//           delay(3000)
//            println("Job ended")
//        }
//
//        myJob.cancel()

        // laufen parallel
//        lifecycleScope.launch { firstCoroutine()
//        }
//
//        lifecycleScope.launch { secondCoroutine()
//        }
//
//        lifecycleScope.launch { thirdCoroutine()
//        }

        // laufen hintereinander
        lifecycleScope.launch {
            firstCoroutine()
            secondCoroutine()
            thirdCoroutine()
        }
    }

    private suspend fun firstCoroutine() {
        println("First MyCoroutine Start!")
        delay(5000)
        println("First MyCoroutine Ended")
    }

    private suspend fun secondCoroutine() {
        println("Second MyCoroutine Start!")
        delay(500)
        println("Second MyCoroutine Ended")
    }

    private suspend fun thirdCoroutine() {
        println("Third MyCoroutine Start!")
        delay(7000)
        println("Third MyCoroutine Ended")
    }
}
