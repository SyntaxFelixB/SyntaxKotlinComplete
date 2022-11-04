package de.syntax_institut.funappsvorlage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.funappsvorlage.R

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class JokeAdapter(
    private val dataset: List<Any>
) : RecyclerView.Adapter<JokeAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSetup: TextView = itemView.findViewById(R.id.tvSetup)
        val tvDelivery: TextView = itemView.findViewById(R.id.tvDelivery)
        val btnShowDelivery: Button = itemView.findViewById(R.id.btnShowDelivery)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_joke, parent, false)

        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // Hole den Joke aus dem dataset
        // TODO

        // weise den TextViews den Text der Vorlage und der Antwort aus dem Joke zu
        // TODO

        // setze den Click Listener auf btnShowDelivery
        holder.btnShowDelivery.setOnClickListener {
            holder.tvDelivery.visibility = View.VISIBLE
            holder.btnShowDelivery.visibility = View.INVISIBLE
        }
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
