package com.example.kotlinbasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.ItemAdapter

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = ItemAdapter(this, getList())

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)
    }

    private fun getList(): List<Any> {

        val currentArtist = "Mean Boy"

        var myList = mutableListOf<String>(
            "Generic Animal",
            "Lust for Youth",
            "Insecure Men",
            currentArtist,
            "Junior Boys",
            "Tocotronic",
            "Dope Lemon",
            "Bon Iver",
            "Matia Bazar",
            "Beach House",
            "Yung Lean",
            "Picasso"
        )

        myList.remove("Picasso")
        myList.shuffle()
        myList.sort()
        myList.sortBy { it }

        return myList
    }
}
