package de.syntax_institut.telefonbuch.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import de.syntax_institut.telefonbuch.R
import de.syntax_institut.telefonbuch.ui.main.MainFragmentDirections

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class ContactAdapter(
    private val dataset: List<Any>
) : RecyclerView.Adapter<ContactAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvItemName)
        val tvNumber: TextView = itemView.findViewById(R.id.tvItemNumber)
        val cvContact: MaterialCardView = itemView.findViewById(R.id.cvContact)
        val ibCallContact: ImageButton = itemView.findViewById(R.id.ibCallContact)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // Hole den Kontakt aus dem dataset
        val contact = dataset[position]

        // Setze den Namen und die Telefonnummer
        // TODO

        // Weise der Variablen contactId die id aus dem Contact Objekt zu
        val contactId: Long = 0 // TODO

        // Setze einen Click Listener auf die CardView, in dem zum EditFragment navigiert wird
        holder.cvContact.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToEditFragment(contactId))
        }

        // Setze einen Click Listener auf den Call Button, in dem ein Dial Intent gestartet wird
        // -> BONUSAUFGABE
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
