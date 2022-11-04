package de.syntaxinstitut.ferienwohnungfinder.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.ferienwohnungfinder.data.dataclasses.AppartmentData
import de.syntaxinstitut.ferienwohnungfinder.databinding.ListItemAppartmentBinding

class AppartmentAdapter(private val items:List<AppartmentData>): RecyclerView.Adapter<AppartmentAdapter.MyViewHolder>() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Innere Klasse um die Elemente im View zu erreichen */
    class MyViewHolder(val binding: ListItemAppartmentBinding) : RecyclerView.ViewHolder(binding.root)


    /* -------------------- Lifecycle -------------------- */

    /**
     * Lifecycle Methode, wird aufgerufen, wenn der ViewHolder erstellt wird
     *
     * @param parent      Eltern-View-Group
     * @param viewType    Art des Views
     *
     * @return Den ViewHolder der den RecyclerView und die Anzeige verbindet
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListItemAppartmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    /**
     * Lifecycle Methode, wird aufgerufen, wenn der ViewHolder mit der Anzeige verbunden wird
     *
     * @param holder      Der ViewHolder der den RecyclerView kontrolliert
     * @param position    Position des Elementes das gerade abgerufen wird
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = items[position]

        val binding = holder.binding

        binding.txtTitle.text = data.title
        binding.txtAddress.text = data.address

        binding.imgAppartmentView.setImageResource(data.image)

        binding.txtSleepRooms.text = data.sleepRooms.toString()
        binding.txtSize.text = "${data.size} m²"
        binding.txtPersons.text = data.persons.toString()

        binding.txtPetsAllowed.text = if (data.petsAllowed) {
            "Ja"
        } else {
            "Nein"
        }

        binding.txtPricePerNight.text = "${data.pricePerNight} €"
    }


    /**
     * Lifecycle Methode zum Abfragen der Anzahl der Elemente
     *
     * @return Anzahl der Elemente
     */
    override fun getItemCount(): Int {
        return items.size
    }


}