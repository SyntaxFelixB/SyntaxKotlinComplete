package com.example.datentypenuniversum

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.datentypenuniversum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var errors: MutableList<String> = mutableListOf()

    /**
     * Lifecycle onCreate method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // test student list
        val entfZuErdeNum = Entfernungen().distanceToEarth() // km
        if (entfZuErdeNum[0] != 77300000 || entfZuErdeNum[0] !is Int) {
            errors.add("merkur")
        }
        if (entfZuErdeNum[1] != 38200000 || entfZuErdeNum[1] !is Int) {
            errors.add("venus")
        }
        if (entfZuErdeNum[2] != 360000 || entfZuErdeNum[2] !is Int) {
            errors.add("mond")
        }
        if (entfZuErdeNum[3].toInt() != 0 || entfZuErdeNum[3] !is Byte) {
            errors.add("erde")
        }
        if (entfZuErdeNum[4].toInt() != 408 || entfZuErdeNum[4] !is Short) {
            errors.add("iss")
        }
        if (entfZuErdeNum[5] != 55700000 || entfZuErdeNum[5] !is Int) {
            errors.add("mars")
        }
        if (entfZuErdeNum[6] != 588500000 || entfZuErdeNum[6] !is Int) {
            errors.add("jupiter")
        }
        if (entfZuErdeNum[7] != 1195500000 || entfZuErdeNum[7] !is Int) {
            errors.add("saturn")
        }
        if (entfZuErdeNum[8] != 2518900000f || entfZuErdeNum[8] !is Float) {
            errors.add("uranus")
        }
        if (entfZuErdeNum[9] != 4305900000f || entfZuErdeNum[9] !is Float) {
            errors.add("neptun")
        }

        val ae = 147000000.0 // km

        // student casting
        val entfSonneNum = mutableListOf<Number>()
        entfSonneNum.apply {
            add(ae - entfZuErdeNum[0].toDouble())
            add(ae - entfZuErdeNum[1].toLong())
            add(ae - entfZuErdeNum[2].toLong())
            add(ae + entfZuErdeNum[3].toShort())
            add(ae + entfZuErdeNum[4].toInt())
            add(ae + entfZuErdeNum[5].toDouble())
            add(ae + entfZuErdeNum[6].toFloat())
            add(ae + entfZuErdeNum[7].toFloat())
            add(ae + entfZuErdeNum[8].toDouble())
            add(ae + entfZuErdeNum[9].toLong())
        }
        val entfSonneFloat = Entfernungen().distanceToSunAE(entfSonneNum)
        // set planets pos & size & Test TN casting
        setPlanetVals(
            binding.ivMerkur,
            if (entfSonneFloat[0] !is Float || entfSonneFloat[0] != 0.46f) {
                -1
            } else {
                20
            },
            100
        )
        setPlanetVals(
            binding.ivVenus,
            if (entfSonneFloat[1] !is Float || entfSonneFloat[1] != 0.72f) {
                -1
            } else {
                30
            },
            160
        )
        setPlanetVals(
            binding.ivMond,
            if (entfSonneFloat[2] !is Float || entfSonneFloat[2] != 0.98f) {
                -1
            } else {
                40
            },
            40
        )
        setPlanetVals(
            binding.ivErde,
            if (entfSonneFloat[3] !is Float || entfSonneFloat[3] != 0.98f) {
                -1
            } else {
                40
            },
            180
        )
        setPlanetVals(
            binding.ivIss,
            if (entfSonneFloat[4] !is Float || entfSonneFloat[4] != 0.98f) {
                -1
            } else {
                40
            },
            20
        )
        setPlanetVals(
            binding.ivMars,
            if (entfSonneFloat[5] !is Float || entfSonneFloat[5] != 1.35f) {
                -1
            } else {
                50
            },
            130
        )
        setPlanetVals(
            binding.ivJupiter,
            if (entfSonneFloat[6] !is Float || entfSonneFloat[6] != 4.91f) {
                -1
            } else {
                60
            },
            210
        )
        setPlanetVals(
            binding.ivSaturn,
            if (entfSonneFloat[7] !is Float || entfSonneFloat[7] != 8.97f) {
                -1
            } else {
                70
            },
            210
        )
        setPlanetVals(
            binding.ivUranus,
            if (entfSonneFloat[8] !is Float || entfSonneFloat[8] != 17.82f) {
                -1
            } else {
                80
            },
            200
        )
        setPlanetVals(
            binding.ivNeptun,
            if (entfSonneFloat[9] !is Float || entfSonneFloat[9] != 29.76f) {
                -1
            } else {
                90
            },
            130
        )
    }

    /**
     * sets planet position in percent of screen size
     */
    private fun setPlanetVals(planet: ImageView, position: Int, size: Int) {
        if (errors.contains(planet.contentDescription) || position == -1) {
            return
        }
        val dpWidth = this.resources.displayMetrics.widthPixels
        val marginStart = dpWidth / 100 * position - size / 2
        val param = planet.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(marginStart, 0, 0, 0)
        param.height = size
        param.width = size
        planet.layoutParams = param
    }
}
