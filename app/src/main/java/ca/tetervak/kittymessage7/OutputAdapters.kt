package ca.tetervak.kittymessage7

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ca.tetervak.kittymessage7.model.CatMessage
import ca.tetervak.kittymessage7.util.DateTimeStamp
import java.util.*

@BindingAdapter("app:date")
fun setDate(textView: TextView, date: Date?) {
    if (date is Date)
        textView.text = DateTimeStamp.formatDate(date)
}

@BindingAdapter("app:time")
fun setTime(textView: TextView, date: Date?) {
    if (date is Date)
        textView.text = DateTimeStamp.formatTime(date)
}

@BindingAdapter("app:message")
fun setCatMessage(textView: TextView, catMessage: CatMessage?) {
    if (catMessage is CatMessage) {
        val catMessages = textView.resources.getStringArray(R.array.cat_messages)
        textView.text = catMessages[catMessage.ordinal]
    }
}

@BindingAdapter("app:delivery")
fun setDelivery(textView: TextView, isUrgent: Boolean?) {
    if (isUrgent is Boolean) {
        val context = textView.context
        textView.text =
                if (isUrgent) {
                    context.getString(R.string.urgent)
                } else {
                    context.getString(R.string.not_urgent)
                }
    }
}



