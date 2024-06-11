package com.lab_4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        // Отримання посилання на SeekBar
        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        // Встановлення обробника подій для SeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Оновлення прогресу
                Toast.makeText(this@SecondActivity, "Progress: $progress", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Дії при початку трекінгу
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Дії при зупинці трекінгу
            }
        })
    }
}

