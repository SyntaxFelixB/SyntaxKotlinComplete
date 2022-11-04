package de.syntax_institut.flaschendrehen

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Diese Liste enthält alle Herz-ImageViews
        val hearts = listOf<ImageView>(
            findViewById(R.id.herz0),
            findViewById(R.id.herz1),
            findViewById(R.id.herz2),
            findViewById(R.id.herz3),
            findViewById(R.id.herz4),
            findViewById(R.id.herz5),
            findViewById(R.id.herz6),
            findViewById(R.id.herz7)
        )
        // Diese Liste enthält die richtigen Winkel der Herzen
        val heartAngles = listOf(
            0f, 45f, 90f, 135f, 180f, 225f, 270f, 315f
        )

        // Diese Liste enthält alle Winkel, die die Flasche annehmen soll
        val angles = listOf(
            0f, 15f, 30f, 45f, 60f, 75f, 90f, 105f, 120f, 135f, 150f, 165f, 180f, 195f, 210f, 225f, 240f, 255f, 270f, 285f, 300f, 315f, 330f, 345f
        )

        // Hier wird ein zufälliges Herz aus der Liste sichtbar gemacht
        val randomHeartIndex = Random.nextInt(0, hearts.size)
        hearts[randomHeartIndex].visibility = View.VISIBLE

        // Diese Variable speichert den Winkel des sichbaren Herzes
        val heartAngle = heartAngles[randomHeartIndex]

        /**
         * Schreibe ab hier deinen Code
         */

        // Hole die Views
        // TODO Schreibe hier deinen Code

        // Der Button bekommt einen onClickListener
        // TODO Schreibe hier deinen Code
    }
}
