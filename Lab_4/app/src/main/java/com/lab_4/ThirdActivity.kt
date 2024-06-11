package com.lab_4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Отримання посилань на RadioButton та CheckBox
        val radioButton1 = findViewById<RadioButton>(R.id.radioButton1)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)

        // Встановлення обробників подій для RadioButton
        radioButton1.setOnClickListener {
            if (radioButton1.isChecked) {
                Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show()
            }
        }

        radioButton2.setOnClickListener {
            if (radioButton2.isChecked) {
                Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show()
            }
        }

        // Встановлення обробника подій для CheckBox
        checkBox.setOnClickListener {
            if (checkBox.isChecked) {
                Toast.makeText(this, "CheckBox is checked", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "CheckBox is unchecked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


