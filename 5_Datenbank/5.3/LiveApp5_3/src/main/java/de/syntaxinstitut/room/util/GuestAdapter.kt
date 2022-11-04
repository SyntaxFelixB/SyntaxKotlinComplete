package de.syntaxinstitut.room.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.room.R
import de.syntaxinstitut.room.data.datamodels.Guest
import de.syntaxinstitut.room.ui.main.MainFragmentDirections

// der Adapter braucht den Context um auf String Resourcen zuzugreifen
// und die Liste an Jokes um sie für die RecyclerView vorzubereiten
class GuestAdapter(
    private val dataset: List<Guest>
) : RecyclerView.Adapter<GuestAdapter.ItemViewHolder>() {

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val guestName: TextView = view.findViewById(R.id.item_name_text)
        val guestFood: TextView = view.findViewById(R.id.item_food_text)
        val guestRow: ConstraintLayout = view.findViewById(R.id.item_layout)
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.guestName.text = item.name
        holder.guestFood.text = item.food

        holder.guestRow.setOnClickListener {
            holder.view.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToEditFragment(item.id))
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
