package com.example.vehicle

import android.graphics.drawable.AnimatedVectorDrawable
import android.widget.ImageView

/** CABRIO KLASSE: ERBT VON DER CAR KLASSE **/
class Cabrio(speed: Int, tankVolume: Int, doorCount: Int) : Car(speed, tankVolume, doorCount) {

    private var sunRoofOpened = false
    override var carImage = R.drawable.cabrio_animation_open

    /** CABRIO ACTION: DACH ÖFFNEN UND SCHLIEßEN **/
    override fun action(iv: ImageView) {
        // TODO
    }

    /** ANIMATION DES DACHES **/
    fun animation(iv: ImageView) {
        iv.setImageResource(carImage)
        var animatedCabrio: AnimatedVectorDrawable = iv.drawable as AnimatedVectorDrawable
        animatedCabrio.start()
    }
}
