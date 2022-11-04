package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recyclerview.adapter.ItemAdapter
import com.example.recyclerview.data.Datasource
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Liste an Reisezielen wird von der Datasource geladen
        val vacations = Datasource().loadVacations()

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.recyclerView

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = ItemAdapter(this, vacations)

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)
    }
}



