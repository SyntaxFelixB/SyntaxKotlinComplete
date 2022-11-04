package de.syntax_institut.chatwithme.data.model

/**
 * Diese Data Klasse steht für eine einzelne Nachricht im ChatFragment
 * @param messageText der Text der Nachricht
 * @param isDraft ob es sich um einen Draft handelt
 */
data class Message(
    var messageText: String,
    var isDraft: Boolean
)
