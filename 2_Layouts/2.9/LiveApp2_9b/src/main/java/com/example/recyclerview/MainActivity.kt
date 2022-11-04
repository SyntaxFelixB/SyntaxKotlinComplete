package com.example.recyclerview

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recyclerview.adapter.ItemAdapter
import com.example.recyclerview.data.Datasource
import com.example.recyclerview.data.model.Joke
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var jokes: MutableList<Joke>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Liste an Jokes wird von der Datasource geladen
        jokes = Datasource().loadJokes()

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.recyclerView

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = ItemAdapter(jokes)

        binding.saveButton.setOnClickListener {
            addJoke()
        }
    }

    private fun addJoke() {

        val newString = binding.newjokeEdit.text.toString()

        if (newString != "") {
            val newJoke = Joke(newString)
            jokes.add(0, newJoke)
            binding.recyclerView.adapter?.notifyItemInserted(0)
            binding.newjokeEdit.setText("")
            Toast.makeText(this, "Joke has been added", Toast.LENGTH_SHORT).show()
        }

        // um das Keyboard nach der Eingabe auszublenden
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}
