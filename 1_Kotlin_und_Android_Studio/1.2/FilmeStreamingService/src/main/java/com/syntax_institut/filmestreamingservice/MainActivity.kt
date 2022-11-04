package com.syntax_institut.filmestreamingservice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.syntax_institut.filmestreamingservice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // variables
    private lateinit var imageSrc: IntArray
    private lateinit var dropdown: Spinner
    private var titlesWithImages: MutableMap<String, Int> = mutableMapOf()
    private var favoriteMovieTitles: MutableList<String> = mutableListOf()
    private var movieTitles: MutableList<String> = mutableListOf()
    private lateinit var binding: ActivityMainBinding
    private lateinit var filmArrayList: ArrayList<FilmItem>

    /**
     * Lifecycle method onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize movie titles
        movieTitles = Mediathek().createDatabase()

        // initialize dropdown
        dropdown = binding.sDropDown
        updateDropDown()

        // add Favorite
        binding.ibAddFavorite.setOnClickListener {
            val title = dropdown.selectedItem?.toString() ?: ""
            if (movieTitles.contains(title)) {
                movieTitles = Mediathek().deleteFromDatabase(movieTitles, title)
                favoriteMovieTitles = Mediathek().addToFavorites(favoriteMovieTitles, title)
                displayList(favoriteMovieTitles)
                updateDropDown()
            }
        }

        // remove favorite on long click
        binding.lvFilme.isClickable = true
        binding.lvFilme.setOnItemLongClickListener { _, _, i, _ ->
            movieTitles.add(favoriteMovieTitles[i])
            favoriteMovieTitles.removeAt(i)
            displayList(favoriteMovieTitles)
            updateDropDown()
            true
        }

        // sort List
        var sortName = true
        binding.ibSortList.setOnClickListener {
            favoriteMovieTitles = if (sortName) {
                Mediathek().sortListAlphabetically(favoriteMovieTitles)
            } else {
                Mediathek().sortListTitleLength(favoriteMovieTitles)
            }
            sortName = !sortName
            displayList(favoriteMovieTitles)
        }

        // reverse List
        binding.ibReverse.setOnClickListener {
            favoriteMovieTitles = Mediathek().invertList(favoriteMovieTitles)
            displayList(favoriteMovieTitles)
        }

        // fill image src
        imageSrc = intArrayOf(
            R.drawable.film_1,
            R.drawable.film_2,
            R.drawable.film_3,
            R.drawable.film_4,
            R.drawable.film_5,
            R.drawable.film_6,
            R.drawable.film_7,
            R.drawable.film_8,
            R.drawable.film_9,
            R.drawable.film_10,
            R.drawable.film_11,
            R.drawable.film_12,
            R.drawable.film_13,
            R.drawable.film_14
        )

        // assign image sources to titles
        for (title in movieTitles) {
            val imgSrc = Random.nextInt(0, imageSrc.size)
            titlesWithImages[title] = imageSrc[imgSrc]
        }
    }

    /**
     * displays the given list of titles
     */
    private fun displayList(titles: MutableList<String>) {
        filmArrayList = ArrayList()
        for (title in titles) {
            val filmItem = FilmItem(titles[titles.indexOf(title)], titlesWithImages[title]!!)
            filmArrayList.add(filmItem)
        }

        binding.lvFilme.adapter = FilmeAdapter(this, filmArrayList)
    }

    /**
     * updates the dropdown menu after list change
     */
    private fun updateDropDown() {
        dropdown.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            movieTitles.toTypedArray()
        )
    }
}
