package de.syntaxinstitut.firebaselogin.data

import com.google.firebase.firestore.DocumentId

data class Player(
    @DocumentId
    val id: String = "",
    val name: String = "",
    val level: Long = 1
)
