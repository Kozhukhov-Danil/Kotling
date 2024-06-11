package com.lab_5

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.lab_5.databinding.ActivityMainBinding

class EventHandler(private val binding: ActivityMainBinding) {
    private var isRed = false

    fun setupListeners() {
        binding.button1.setOnClickListener {
            binding.textView.text = "Button 1 Clicked!"
        }

        binding.button2.setOnClickListener {
            if (isRed) {
                binding.button2.setBackgroundColor(Color.BLUE)
            } else {
                binding.button2.setBackgroundColor(Color.RED)
            }
            isRed = !isRed
        }

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Before text changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.textView.text = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                // After text changed
            }
        })

        binding.editText.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                Toast.makeText(view.context, "EditText Focused", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(view.context, "EditText Lost Focus", Toast.LENGTH_SHORT).show()
            }
        }
    }
}