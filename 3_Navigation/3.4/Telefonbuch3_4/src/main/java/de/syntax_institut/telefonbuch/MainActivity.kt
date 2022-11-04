package de.syntax_institut.telefonbuch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import de.syntax_institut.telefonbuch.adapter.ItemAdapter
import de.syntax_institut.telefonbuch.data.Datasource
import de.syntax_institut.telefonbuch.data.model.Contact
import de.syntax_institut.telefonbuch.databinding.ActivityMainBinding

/**
 * Die Main Activity
 */
class MainActivity : AppCompatActivity() {

    /**
     * Lifecycle Funktion onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Entferne:
        // setContentView(R.layout.activity_main)

        // Die Data Binding Variable
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // hole die Liste mit den Kontakten
        val contacts = Datasource().loadContacts()

        // die RecyclerView bekommt den Adapter
        val itemAdapter = ItemAdapter(contacts)
        binding.recyclerView.adapter = itemAdapter

        // Button fügt einen Listeneintrag hinzu
        binding.btnAdd.setOnClickListener {

            // Hole den Inhalt aus den Textfeldern
            val name = binding.inName.text.toString()
            val number = binding.inPhoneNumber.text.toString()

            // Falls in beiden Textfeldern etwas steht
            if (name != "" && number != "") {
                val position = contacts.size // kann auch ein anderer Index <= contacts.size sein
                contacts.add(position, Contact(name, number))
                itemAdapter.notifyItemInserted(position)
                binding.inName.setText("")
                binding.inPhoneNumber.setText("")
            }
        }
    }
}
