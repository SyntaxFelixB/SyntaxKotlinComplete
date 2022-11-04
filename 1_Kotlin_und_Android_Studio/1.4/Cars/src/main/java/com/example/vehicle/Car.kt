package com.example.vehicle

import android.widget.ImageView

/** CAR KLASSE: OBERKLASSE **/
open class Car(speed: Int, tankVolume: Int, doorCount: Int) {

    open var carImage = R.drawable.car
    private var speed = speed
    private var tankVolume = tankVolume
    private var doorCount = doorCount

    /** VERSCHIEBT IMAGEVIEW AUF DER X ACHSE UM DEN WERT DES SPEEDS **/
    open fun drive(iv: ImageView) {
        iv.x -= speed
    }

    /** VERSCHIEBT IMAGEVIEW ZURÜCK AUF DER X ACHSE UM DEN WERT DES SPEEDS **/
    open fun drive_reverse(iv: ImageView) {
        iv.x += speed
    }

    /** EINE TYP SPEZIFISCHE ACTION: IMPLEMENTIERUNG IN DEN UNTERKLASSEN **/
    open fun action(iv: ImageView) {
    }
}
