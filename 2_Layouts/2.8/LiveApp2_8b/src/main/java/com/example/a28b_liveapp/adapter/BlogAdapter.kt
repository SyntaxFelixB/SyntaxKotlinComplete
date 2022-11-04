package com.example.a28b_liveapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.a28b_liveapp.R
import com.example.a28b_liveapp.data.model.BlogEntry

class BlogAdapter(
    private val dataset: List<BlogEntry>
) : RecyclerView.Adapter<BlogAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.can_image)
        val title = view.findViewById<TextView>(R.id.can_title)
        val text = view.findViewById<TextView>(R.id.can_text)
        val card = view.findViewById<CardView>(R.id.can_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.can_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.image.setImageResource(item.imageResource)
        holder.title.text = item.title
        holder.text.text = item.content

        if (item.old) {
            holder.card.alpha = 0.6f
        } else {
            holder.card.alpha = 1.0f
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
