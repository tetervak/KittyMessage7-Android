package ca.tetervak.kittymessage7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.tetervak.kittymessage7.databinding.ActivityOutputBinding
import ca.tetervak.kittymessage7.model.Envelope

class OutputActivity : AppCompatActivity() {

    companion object{
        const val ENVELOPE = "envelope"
    }

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflate the layout and set the content view
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get the data from the intent
        val envelope = intent.getSerializableExtra(ENVELOPE) as Envelope

        // display the received data
        binding.envelope = envelope

        // make the close button work
        binding.backButton.setOnClickListener { finish() }

    }
}