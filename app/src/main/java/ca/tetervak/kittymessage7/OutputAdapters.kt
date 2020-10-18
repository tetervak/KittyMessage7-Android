package ca.tetervak.kittymessage7

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ca.tetervak.kittymessage7.model.CatMessage
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

object OutputAdapters {

    private val dateFormatter =
        DateTimeFormatter.ofPattern("MMM dd, yyyy")

    private fun formatDate(date: Date?): String? {
        return date?.toInstant()
            ?.atZone(ZoneId.systemDefault())
            ?.toLocalDate()
            ?.format(dateFormatter)
    }

    @BindingAdapter("app:date")
    @JvmStatic
    fun bindDate(textView: TextView, date: Date?){
        textView.text = formatDate(date)
    }

    private val timeFormatter =
        DateTimeFormatter.ofPattern("h:mm:ss a")

    private fun formatTime(date: Date?): String? {
        return date?.toInstant()
            ?.atZone(ZoneId.systemDefault())
            ?.toLocalTime()
            ?.format(timeFormatter)
    }

    @BindingAdapter("app:time")
    @JvmStatic
    fun bindTime(textView: TextView, date: Date?){
        textView.text = formatTime(date)
    }

    @BindingAdapter("app:message")
    @JvmStatic
    fun bindCatMessage(textView: TextView, catMessage: CatMessage){
        val catMessages = textView.resources.getStringArray(R.array.cat_messages)
        textView.text = catMessages[catMessage.ordinal]
    }

    @BindingAdapter("app:delivery")
    @JvmStatic
    fun bindDelivery(textView: TextView, isUrgent: Boolean){
        val context = textView.context
        textView.text =
            if(isUrgent){
                context.getString(R.string.urgent)
            }else{
                context.getString(R.string.not_urgent)
            }
    }

}


