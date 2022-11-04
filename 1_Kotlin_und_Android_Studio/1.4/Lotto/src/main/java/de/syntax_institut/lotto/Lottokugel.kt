package de.syntax_institut.lotto

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * Diese Klasse repräsentiert eine Lottokugel und enthält die Funktionalität,
 * die zum Anzeigen einer Kugel benötigt wird
 */
class Lottokugel(val number: Int) {

    /**
     * Die Funktion drawBall zeigt die Lottokugel an
     * Für den Parameter "activity" kann in der "MainActivity" einfach "this" übergeben werden
     */
    fun drawBall(activity: Activity) {

        // Hole den ersten Ball aus dem Layout
        var ball = activity.findViewById<TextView>(R.id.ball1)
        var ballNr = 1

        // Gehe bis zum nächten Ball der noch nicht angezeigt wird
        while (ball.visibility == View.VISIBLE) {
            ballNr++
            ball = activity.findViewById(
                activity.resources.getIdentifier(
                    "ball$ballNr",
                    "id",
                    activity.packageName
                )
            )
        }

        // Hole die ID für die entprechende Farbe des Balles
        val colorRes = activity.resources.getIdentifier(
            "ball_color$number",
            "color",
            activity.packageName
        )

        // Hole die Farbe und Färbe den Ball
        val color = ContextCompat.getColor(activity, colorRes)
        var ballDrawable: Drawable? = ball.background
        ballDrawable = DrawableCompat.wrap(ballDrawable!!)
        DrawableCompat.setTint(ballDrawable, color)
        ball.background = ballDrawable

        // Setze die Nummer des Balls
        ball.text = number.toString()

        // Zeige den Ball an
        ball.visibility = View.VISIBLE
    }
}
