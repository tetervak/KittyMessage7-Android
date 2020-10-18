package ca.tetervak.kittymessage7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ca.tetervak.kittymessage7.databinding.ActivityInputBinding
import ca.tetervak.kittymessage7.model.CatMessage
import ca.tetervak.kittymessage7.model.Envelope

class InputActivity : AppCompatActivity() {

    private var envelope: Envelope = Envelope()

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflate the layout and set the content view
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bind the envelope to the inputs
        binding.envelope = envelope

        // make the submit button work
        binding.sendButton.setOnClickListener{ showOutput() }
    }

    private fun showOutput(){

        // store the in put data in the intent
        val intent = Intent(this, OutputActivity::class.java).apply {
            putExtra(OutputActivity.ENVELOPE, envelope)
        }

        // start the output activity
        startActivity(intent)
    }
}