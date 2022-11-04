package com.syntax_institut.filmestreamingservice

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FilmeAdapter(private val context: Activity, private val arrayList: ArrayList<FilmItem>) : ArrayAdapter<FilmItem>(
    context, R.layout.list_item_film, arrayList
) {

    /**
     * overrides getView
     */
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item_film, null)

        val filmLogo: ImageView = view.findViewById(R.id.iv_logo)
        val filmTitle: TextView = view.findViewById(R.id.tv_title)

        filmLogo.setImageResource(arrayList[position].imageSrc)
        filmTitle.text = arrayList[position].title

        return view
    }
}
