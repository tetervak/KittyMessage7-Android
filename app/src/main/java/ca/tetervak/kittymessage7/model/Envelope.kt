package ca.tetervak.kittymessage7.model

import java.io.Serializable
import java.util.*

data class Envelope(
        var catMessage: CatMessage = CatMessage.MEW,
        var urgent: Boolean = true,
        var timeStamp: Date = Date()
): Serializable