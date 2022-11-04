package com.example.a21_liveapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton = findViewById<Button>(R.id.generate_button)

        generateButton.setOnClickListener {
            generateGreeting()
        }
    }

    private fun generateGreeting() {

        val firstNameField = findViewById<TextInputEditText>(R.id.first_name_edit_input)
        val lastNameField = findViewById<TextInputEditText>(R.id.last_name_edit_input)
        val politeSwitch = findViewById<SwitchCompat>(R.id.polite_switch)

        val greetingText = findViewById<TextView>(R.id.greeting_text)

        val firstName: String = firstNameField.text.toString()
        val lastName: String = lastNameField.text.toString()
        val polite: Boolean = politeSwitch.isChecked

        greetingText.text = makeTheText(firstName, lastName, polite)
    }

    private fun makeTheText(firstName: String, lastName: String, polite: Boolean): String {

        var resultText = ""

        if (polite) {
            resultText = getString(R.string.greeting_polite, firstName, lastName)
        } else {
            resultText = getString(R.string.greeting, firstName)
        }

        return resultText
    }
}
