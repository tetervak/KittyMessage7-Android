package ca.tetervak.kittymessage7

import android.view.View
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import ca.tetervak.kittymessage7.model.CatMessage

object InputAdapters {

    @BindingAdapter("app:message")
    @JvmStatic
    fun setCatMessage(spinner: Spinner, catMessage: CatMessage){
        val messageIndex = catMessage.ordinal

        // important to break potential infinite loops
        if (spinner.selectedItemPosition != messageIndex){
            spinner.setSelection(messageIndex)
        }
    }

    @BindingAdapter("app:messageAttrChanged")
    @JvmStatic
    fun setMessageChangeListener(spinner: Spinner, attrChange: InverseBindingListener){

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                attrChange.onChange()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    @InverseBindingAdapter(attribute = "app:message")
    @JvmStatic
    fun getCatMessage(spinner: Spinner): CatMessage{
        return CatMessage.values()[spinner.selectedItemPosition]
    }

    @BindingAdapter("app:delivery")
    @JvmStatic
    fun setIsUrgent(checkBox: CheckBox, isUrgent: Boolean){

        // important to break potential infinite loops
        if(checkBox.isChecked != isUrgent){
            checkBox.isChecked = isUrgent
        }
    }

    @InverseBindingAdapter(attribute = "app:delivery")
    @JvmStatic
    fun getIsUrgent(checkBox: CheckBox): Boolean{
        return checkBox.isChecked
    }

    @BindingAdapter("app:deliveryAttrChanged")
    @JvmStatic
    fun setDeliveryChangeListener(checkBox: CheckBox, attrChange: InverseBindingListener){
        checkBox.setOnCheckedChangeListener { _, _ -> attrChange.onChange() }
    }
}



