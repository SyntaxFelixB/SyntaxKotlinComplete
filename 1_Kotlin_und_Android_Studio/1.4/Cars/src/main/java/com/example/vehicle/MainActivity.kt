package com.example.vehicle

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    /** INDEX DES AUSGEWÄHLTEN CARS**/
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** IMAGE VIEW CONTAINER ZUM LADEN DES AUTOBILDES**/
        var imageView: ImageView = findViewById(R.id.vehichle_image_view)

        /**  LISTE DER AUTO OBJEKTE **/
        // TODO: Ergänze nach Cabrio um 2 weitere Objekte
        var cars = listOf<Car>(
            Car(50, 30, 2),
            Cabrio(200, 40, 2)
        )

        // BEIM START DER APP WIRD DER CONTAINER IMMER AUF DAS CAR GESETZT
        imageView.setImageResource(cars[i].carImage)

        /** ZUGRIFF AUF DIE BUTTONS IM LAYOUT **/
        // TODO

        /** LISTENER AUF DIE BUTTONS **/
        // TODO
    }
}
