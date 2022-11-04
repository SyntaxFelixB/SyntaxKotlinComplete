package com.example.a28b_liveapp.data

import com.example.a28b_liveapp.R
import com.example.a28b_liveapp.data.model.BlogEntry

class Datasource {

    fun loadBlogEntries(): List<BlogEntry> {
        return listOf(
            BlogEntry(
                "Ein Tag im Garten",
                "Auch auf häufig gestellte Fragen findest du Antworten in unserem Ratgeber. Sofern vorhanden, bieten wir dir auch interessante Test-Videos. Des Weiteren findest du auf dieser Seite auch einige wichtige Informationen, auf die du unbedingt achten solltest, wenn du dir eine Gießkanne kaufen möchtest.",
                R.drawable.can1,
                true
            ),
            BlogEntry(
                "Die Gießkanne ist ein Alptraum",
                "Kaufen Sie diese bitte nicht bricht sofort durch und Wasser ist überall!!! Eine Gießkanne besteht aus einem Gefäß, einem Griff, einer Tülle und einer Brause. Sie besteht normalerweise aus Kunststoff, Metall, Keramik, Glas, Kupfer oder Zink...",
                R.drawable.can2,
                false
            ),
            BlogEntry(
                "Beste Innovation seit es Wasser gibt",
                "Mein Tag mit der WaterCan 3000 war wie ein Traum. Sofern vorhanden, bieten wir dir auch interessante Test-Videos. Des Weiteren findest du auf dieser Seite auch einige wichtige Informationen, auf die du unbedingt achten solltest, wenn du dir eine Gießkanne kaufen möchtest...",
                R.drawable.can4,
                false
            )
        )
    }
}