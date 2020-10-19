package ca.tetervak.kittymessage7.util

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class DateTimeStamp {

    companion object{

        private val formatterDate =
            DateTimeFormatter.ofPattern("MMM dd, yyyy")

        private val formatterTime = DateTimeFormatter.ofPattern("h:mm:ss a")

        private val formatterDateTime =
            DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy - h:mm a")

        // had to annotate with @JvmStatic to use them in the binding

        @JvmStatic
        fun formatDate(date: Date?): String? {
            return date?.toInstant()
                    ?.atZone(ZoneId.systemDefault())
                    ?.toLocalDate()
                    ?.format(formatterDate)
        }

        @JvmStatic
        fun formatTime(date: Date?): String? {
            return date?.toInstant()
                        ?.atZone(ZoneId.systemDefault())
                        ?.toLocalTime()
                        ?.format(formatterTime)
        }

        @JvmStatic
        fun formatDateTime(date: Date?): String? {
            return date?.toInstant()
                        ?.atZone(ZoneId.systemDefault())
                        ?.toLocalDateTime()
                        ?.format(formatterDateTime)
        }
    }
}