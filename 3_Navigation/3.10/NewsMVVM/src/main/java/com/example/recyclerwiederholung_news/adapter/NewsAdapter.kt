package com.example.recyclerwiederholung_news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwiederholung_news.R
import com.example.recyclerwiederholung_news.data.model.NewsArticle
import com.example.recyclerwiederholung_news.ui.HomeFragmentDirections

class NewsAdapter(
    private val dataset: List<NewsArticle>
) : RecyclerView.Adapter<NewsAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.news_title_text)
        val location: TextView = view.findViewById(R.id.news_location_text)
        val date: TextView = view.findViewById(R.id.news_date_text)
        val image: ImageView = view.findViewById(R.id.news_image)
        val card: CardView = view.findViewById(R.id.news_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.title.text = item.title
        holder.location.text = item.location
        holder.date.text = item.date
        holder.image.setImageResource(item.imageResourceId)

        holder.card.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(item.id))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
