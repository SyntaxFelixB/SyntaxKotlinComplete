package com.example.recyclerview.data

import com.example.recyclerview.R
import com.example.recyclerview.data.model.Vacation

class Datasource {

    fun loadVacations(): List<Vacation> {
        return listOf(
            Vacation(R.string.preis1, R.drawable.urlaub1),
            Vacation(R.string.preis2, R.drawable.urlaub2),
            Vacation(R.string.preis3, R.drawable.urlaub3),
            Vacation(R.string.preis4, R.drawable.urlaub4),
            Vacation(R.string.preis1, R.drawable.urlaub5),
            Vacation(R.string.preis2, R.drawable.urlaub6),
            Vacation(R.string.preis3, R.drawable.urlaub7),
            Vacation(R.string.preis4, R.drawable.urlaub8),
            Vacation(R.string.preis1, R.drawable.urlaub9),
            Vacation(R.string.preis2, R.drawable.urlaub10),
            Vacation(R.string.preis3, R.drawable.urlaub11),
            Vacation(R.string.preis4, R.drawable.urlaub12),
            Vacation(R.string.preis1, R.drawable.urlaub1),
            Vacation(R.string.preis2, R.drawable.urlaub2),
            Vacation(R.string.preis3, R.drawable.urlaub3),
            Vacation(R.string.preis4, R.drawable.urlaub4),
            Vacation(R.string.preis1, R.drawable.urlaub5)
        )
    }
}


