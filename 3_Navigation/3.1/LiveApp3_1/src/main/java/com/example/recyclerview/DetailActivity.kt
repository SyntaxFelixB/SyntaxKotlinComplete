package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val stringId = intent.extras?.getInt("stringId")
        val imageId = intent.extras?.getInt("imageId")

        var detailText = ""

        if (stringId != null) {
            detailText = getString(stringId)
            binding.detailText.text = detailText
        } else {
            binding.detailText.text = "Urlaub ausgebucht! Fahr doch woanders hin"
        }

        if (imageId != null) {
            binding.detailCardLayout.setBackgroundResource(imageId)
        }

        binding.detailShareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Ich habe diesen tollen Urlaub gefunden für nur $detailText !!!")
            intent.type = "text/plain"
            val shareIntent = Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }
    }
}
