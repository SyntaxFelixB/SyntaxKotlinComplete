package com.example.recyclerwiederholung_news.data

import com.example.recyclerwiederholung_news.R
import com.example.recyclerwiederholung_news.data.model.NewsArticle

class Repository {

    fun loadNews(): List<NewsArticle> {

        return listOf(
            NewsArticle(
                "Die Top 10 gefährlichsten Tiere Deutschlands!",
                R.drawable.raubtier,
                "Deutschland",
                "23.06.2022"
            ),
            NewsArticle(
                "Wird künstliche Intelligenz uns bald alle ersetzen?!? Das sagen Wissenschaftler…",
                R.drawable.ai,
                "Welt",
                "26.06.2022"
            ),
            NewsArticle(
                "Die Hochhauspflicht - das Ende von Einfamilienhäusern? Lies alles dazu…",
                R.drawable.hochhaus,
                "Schweiz",
                "28.06.2022"
            ),
            NewsArticle(
                "Ist Leonardo Di Caprio der neue Spiderman? Hollywood spielt verrückt",
                R.drawable.leo,
                "USA",
                "30.06.2022"
            ),
            NewsArticle(
                "Kommt bald Cast Away Teil 2? Tom Hanks leaked die Infos!",
                R.drawable.cast_away,
                "USA",
                "13.07.2022"
            )
        )
    }
}
