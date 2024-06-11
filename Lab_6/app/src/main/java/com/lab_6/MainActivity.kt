package com.lab_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.PersistableBundle
import com.lab_6.databinding.ActivityMainBinding
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            user = savedInstanceState.getParcelable("USER")
        } else {
            user = User("John Doe", 25)
        }

        binding.buttonToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("USER", user)
            }
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("USER", user)
    }
}

@Parcelize
data class User(val name: String, val age: Int) : Parcelable
