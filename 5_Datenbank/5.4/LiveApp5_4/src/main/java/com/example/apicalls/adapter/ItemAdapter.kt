package com.example.apicalls.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.apicalls.R
import com.example.apicalls.data.datamodels.Drink

class ItemAdapter(
    private var dataset: List<Drink>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Drink>) {
        dataset = list
        notifyDataSetChanged()
    }

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.list_image)
        val textView = view.findViewById<TextView>(R.id.list_text)
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

        holder.textView.text = item.name

        val imgUri = item.picture.toUri().buildUpon().scheme("https").build()

        holder.imageView.load(imgUri) {
            error(R.drawable.ic_round_broken_image_24)
            transformations(RoundedCornersTransformation(10f))
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
