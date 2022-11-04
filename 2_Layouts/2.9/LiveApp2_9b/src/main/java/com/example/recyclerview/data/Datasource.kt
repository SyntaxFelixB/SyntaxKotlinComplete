package com.example.recyclerview.data


import com.example.recyclerview.data.model.Joke

class Datasource {

    fun loadJokes(): MutableList<Joke> {
        return mutableListOf(
            Joke("Einem Mann fällt sein Smartphone runter. Dem Gerät ist kein Schaden entstanden. Wie ist das möglich? Es war im Flugmodus."),
            Joke("Treffen sich zwei Kerzen. Fragt die eine: \"Und was hast du vor? Meint die andere: \"Ich geh aus!\""),
            Joke("Zwei Psychiater stehen am Bahnhof und haben den Zug verpasst. Sagt der eine zum anderen: \"Sollen wir darüber reden?\""),
            Joke("Was ist weiß und stört beim essen? Eine Lawine.")
        )
    }
}


