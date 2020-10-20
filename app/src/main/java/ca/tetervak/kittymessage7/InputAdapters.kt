package ca.tetervak.kittymessage7

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import ca.tetervak.kittymessage7.model.CatMessage

@BindingAdapter("app:message")
fun setCatMessage(spinner: Spinner, catMessage: CatMessage) {
    val messageIndex = catMessage.ordinal

    // important to break potential infinite loops
    if (spinner.selectedItemPosition != messageIndex) {
        spinner.setSelection(messageIndex)
    }
}

@BindingAdapter("app:messageAttrChanged")
fun setMessageChangeListener(spinner: Spinner, attrChange: InverseBindingListener) {

    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            attrChange.onChange()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

    }
}

@InverseBindingAdapter(attribute = "app:message")
fun getCatMessage(spinner: Spinner): CatMessage {
    return CatMessage.values()[spinner.selectedItemPosition]
}




